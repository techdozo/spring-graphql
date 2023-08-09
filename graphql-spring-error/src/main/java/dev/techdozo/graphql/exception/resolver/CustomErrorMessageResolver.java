package dev.techdozo.graphql.exception.resolver;

import dev.techdozo.graphql.exception.*;
import graphql.*;
import graphql.schema.*;
import java.util.*;
import org.springframework.graphql.execution.*;
import org.springframework.stereotype.*;

@Component
public class CustomErrorMessageResolver extends DataFetcherExceptionResolverAdapter {
  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

    if (ex instanceof ResourceNotFoundException resourceNotFoundException) {
      var errorCode = resourceNotFoundException.getErrorCode();
      var message = resourceNotFoundException.getMessage();
      return GraphqlErrorBuilder.newError(env)
          .errorType(CustomErrorType.RESOURCE_NOT_FOUND)
          .message(message)
          .extensions(Map.of("errorCode", errorCode.getShortCode()))
          .build();
    }
    return null;
  }
}
