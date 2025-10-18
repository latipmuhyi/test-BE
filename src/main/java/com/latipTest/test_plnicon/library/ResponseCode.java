package com.latipTest.test_plnicon.library;

import lombok.Getter;

@Getter
public enum ResponseCode {
    NO_END_POINT(404, "ENDPOINT NOT FOUND"),
    SUCCESS(200, "OK"),
    SERVER_ERROR(500, "INTERNAL SERVER ERROR"),
    DATABASE_ERROR(501, "INTERNAL SERVER ERROR"),
    SERVER_RESOURCE_ERROR(503, "SERVER RESOURCE NOT FOUND"),
    PAYMENT_ERROR(501, "PAYMENT ERROR"),
    VALIDATION(100, "ERROR MAPPING"),
    TypeMismatch(103, "ERROR MAPPING"),
    OPT(102, "Error OTP"),
    OPTLimit(112, "Error OTP Limit"),
    PasswordMismatch(104, "Password tidak sama"),
    JWTExp(401, "Token is invalid or expired"),
    UnAuthorize(402, "Token Invalid"),
    CookiesNotFound(403, "Token Invalid"), // kue na teing kamana jigana di paok ku si bangsat agni
    UserNotFound(405, "Token Invalid"),
    BadCredential(410, "You have entered an invalid username or password"),
    BadCredentialNoData(411, "You have entered an invalid username or password"),
    BadCredentialBlocked(412, "You have entered an invalid username or password"),
    BadCredentialRegistered(413, "You have error register try login"),
    BadCredentialLimit(414, "You have entered an invalid username or password"), // limit
    CsrfTokenUnValidate(420, "Token Validation Failed"),
    CsrfNotFound(421, "csrf Invalid"),
    NO_DATA(110, "DATA TIDAK DITEMUKAN"),
    NO_DATA_ACCESS(120, "DATA TIDAK DITEMUKAN"),
    NO_DATA_GOVERNMENT(111, "Data dinas tidak ditemukan"),
    BAD_REQUEST(400, "BAD REQUEST" );
    private final Integer code;
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
