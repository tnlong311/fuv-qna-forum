package com.qnaforum.webapp.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4642753456084299295L;
    private String exceptionCode;
    private HttpStatus httpStatus;

    public AppException(Throwable cause, HttpStatus httpStatus) {
        super(cause);
        setHttpStatus(httpStatus);
    }

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        setHttpStatus(httpStatus);
    }

    public AppException(String message) {
        super(message);
        setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}