package com.game.home.httptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class HttpTest {
    @Test
    @DisplayName("httpStatusCodeToStringTest")
    void httpToString(){

        String s = HttpStatus.BAD_REQUEST.toString();
        System.out.println(s);
    }
}
