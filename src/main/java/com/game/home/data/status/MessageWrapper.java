package com.game.home.data.status;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MessageWrapper {
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public MessageWrapper(HttpStatus httpStatus, String message, Object data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }
}
