package br.com.zup.propostas.compartilhada;

import org.springframework.http.HttpStatus;

public class ApiErrorException extends RuntimeException {
    private final HttpStatus httpStatus;

    private final String reason;

    public ApiErrorException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErrorException(String message, HttpStatus httpStatus, String reason) {
        super(message);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErrorException(String message, Throwable cause, HttpStatus httpStatus, String reason) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErrorException(Throwable cause, HttpStatus httpStatus, String reason) {
        super(cause);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus, String reason) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }

}
