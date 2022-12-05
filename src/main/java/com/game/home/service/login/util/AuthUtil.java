package com.game.home.service.login.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AuthUtil {

    public boolean isValidRegex(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(str).matches();
    }

}
