package com.game.home.service.login.message;

import org.springframework.http.HttpStatus;

public enum MessageEnum {
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, false, "형식에 맞지 않는 비밀번호입니다."),
    INVALID_ID(HttpStatus.UNAUTHORIZED, false, "형식에 맞지 않는 아이디입니다."),
    INVALID_EMAIL(HttpStatus.UNAUTHORIZED, false, "형식에 맞지 않는 이메일입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, false, "아이디 또는 비밀번호가 다릅니다."),
    LOGIN_SUCCESS(HttpStatus.OK, true, "로그인 성공");

    private HttpStatus httpStatus;
    private boolean accept;
    private String message;

    MessageEnum(HttpStatus httpStatus, boolean accept, String message) {
        this.httpStatus = httpStatus;
        this.accept = accept;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public boolean isAccept() {
        return accept;
    }

    public String getMessage() {
        return message;
    }
}
