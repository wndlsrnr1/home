package com.game.home.service.login;

import com.game.home.data.member.Member;
import com.game.home.data.status.MessageWrapper;
import com.game.home.service.login.authorize.AuthorizeMethod;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl {

    private final Map<String, AuthorizeMethod> authorizeMethods;

    public LoginServiceImpl(Map<String, AuthorizeMethod> authorizeMethods) {
        this.authorizeMethods = authorizeMethods;
    }

    public MessageWrapper getHttpMessage(Member member) {

        for (String key : authorizeMethods.keySet()) {
            MessageEnum result = authorizeMethods.get(key).authorize(member);
            if (!result.isAccept()){
                return new MessageWrapper(result.getHttpStatus(), result.getMessage(), null);
            }
        }

        // 성공일때
        MessageEnum loginSuccess = MessageEnum.LOGIN_SUCCESS;

        return new MessageWrapper(loginSuccess.getHttpStatus(), loginSuccess.getMessage(), null);
    }


}
