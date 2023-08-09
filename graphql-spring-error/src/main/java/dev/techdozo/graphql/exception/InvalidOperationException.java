package dev.techdozo.graphql.exception;

import java.util.Map;

public class InvalidOperationException extends ServiceException {

  public InvalidOperationException(ErrorCode errorCode,String message, Map<String, String> errorMetaData) {
    super(errorCode,message, errorMetaData);
  }

  public InvalidOperationException(ErrorCode errorCode,
      String message, Map<String, String> errorMetaData, Throwable cause) {
    super(errorCode,message, errorMetaData, cause);
  }
}
