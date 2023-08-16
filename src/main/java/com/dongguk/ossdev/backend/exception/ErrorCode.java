package com.dongguk.ossdev.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Not Found Error
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "Not Exist User"),

    // Server, File Up/DownLoad Error
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    // Bad Request Error
    NOT_END_POINT(HttpStatus.BAD_REQUEST , "Not Exist End Point Error"),

    // Access Denied Error
    ACCESS_DENIED_ERROR(HttpStatus.UNAUTHORIZED, "Access Denied Token Error"),

    // Token Error Set
    TOKEN_INVALID_ERROR(HttpStatus.UNAUTHORIZED, "Invalid Token Error"),
    TOKEN_MALFORMED_ERROR(HttpStatus.UNAUTHORIZED, "Malformed Token Error"),
    TOKEN_EXPIRED_ERROR(HttpStatus.UNAUTHORIZED, "Expired Token Error"),
    TOKEN_TYPE_ERROR(HttpStatus.UNAUTHORIZED, "Type Token Error"),
    TOKEN_UNSUPPORTED_ERROR(HttpStatus.UNAUTHORIZED, "Unsupported Token Error"),
    TOKEN_UNKNOWN_ERROR(HttpStatus.UNAUTHORIZED, "Unknown Error");


    private final HttpStatus httpStatus;
    private final String message;
}
