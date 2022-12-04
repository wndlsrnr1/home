package com.game.home.service.login.authorize;

import com.game.home.data.member.Member;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeIdAndPassword implements AuthorizeMethod{
    @Override
    public MessageEnum authorize(Member member) {
        return null;
    }
}
