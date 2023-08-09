package dev.techdozo.graphql.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class BaseException extends RuntimeException {

  private final Map<String, String> errorMetaData;
  private final ErrorCode errorCode;

  public BaseException(ErrorCode errorCode,String message, Map<String, String> errorMetaData) {
    super(message);
    this.errorCode = errorCode;
    this.errorMetaData = errorMetaData;
  }

  public BaseException(ErrorCode errorCode,String message, Map<String, String> errorMetaData, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
    this.errorMetaData = errorMetaData;
  }
}
