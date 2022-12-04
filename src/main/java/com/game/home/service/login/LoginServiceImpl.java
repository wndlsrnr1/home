package com.game.home.service.login;

import com.game.home.data.member.Member;
import com.game.home.data.status.MessageWrapper;
import com.game.home.service.login.authorize.Authorized;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {

    private final Authorized auth;

    @Autowired
    public LoginServiceImpl(Authorized auth) {
        this.auth = auth;
    }

    public MessageWrapper getHttpMessage(Member member) {

        String[] authArr = {"id", "email", "password", "idAndPassword"};

        for (String authStr : authArr) {
            MessageEnum result = auth.authorize(authStr, member);
            if (!result.isAccept()){
                return new MessageWrapper(result.getHttpStatus(), result.getMessage(), null);
            }
        }

        // 성공일때
        MessageEnum loginSuccess = MessageEnum.LOGIN_SUCCESS;

        return new MessageWrapper(loginSuccess.getHttpStatus(), loginSuccess.getMessage(), null);
    }


}
