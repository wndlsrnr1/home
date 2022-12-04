package com.game.home.service.login.authorize;

import com.game.home.data.member.Member;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Authorized {

    Map<String, String> classes = new ConcurrentHashMap<>();
    AnnotationConfigApplicationContext ac;

    @Autowired
    public Authorized(AnnotationConfigApplicationContext ac) {
        this.ac = ac;
        classes.put("email", "authorizeIdAndPassword");
        classes.put("password", "authorizeValidEmailSequence");
        classes.put("id", "authorizeValidIdSequence");
        classes.put("idAndPassword", "authorizeValidPasswordSequence");
        classes.put("authorizeIdAndPassword", "authorizeIdAndPassword");
        classes.put("authorizeValidEmailSequence", "authorizeValidEmailSequence");
        classes.put("authorizeValidIdSequence", "authorizeValidIdSequence");
        classes.put("authorizeValidPasswordSequence", "authorizeValidPasswordSequence");
    }

    public MessageEnum authorize(String param, Member member) {
        AuthorizeMethod method = ac.getBean(param, AuthorizeMethod.class);
        MessageEnum authorize = method.authorize(member);
        return authorize;
    }

}
