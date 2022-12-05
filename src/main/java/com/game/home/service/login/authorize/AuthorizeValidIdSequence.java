package com.game.home.service.login.authorize;

import com.game.home.data.member.Member;
import com.game.home.service.login.util.AuthUtil;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeValidIdSequence implements AuthorizeMethod{

    private final AuthUtil authUtil;

    public AuthorizeValidIdSequence(AuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    @Override
    public MessageEnum authorize(Member member) {
        String id = member.getId();

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,12}$";

        boolean isValidEmail = authUtil.isValidRegex(id, emailRegex);
        boolean isValidId = authUtil.isValidRegex(id, idRegex);

        if (isValidEmail || isValidId){
            return MessageEnum.VALID_SEQUENCE;
        }

        return MessageEnum.INVALID_ID;
    }



}
