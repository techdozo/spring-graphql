package dev.techdozo.graphql.exception.resolver;

import graphql.*;

public enum CustomErrorType implements ErrorClassification {
  RESOURCE_NOT_FOUND,
  INVALID_OPERATION;
}
