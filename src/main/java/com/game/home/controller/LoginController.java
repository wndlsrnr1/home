package com.game.home.controller;

import com.game.home.data.member.Member;
import com.game.home.data.status.Message;
import com.game.home.data.status.MessageWrapper;
import com.game.home.service.login.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginServiceImpl loginService;

    @Autowired
    public LoginController(LoginServiceImpl joinService) {
        this.loginService = joinService;
    }


    @GetMapping
    public String loginView() {
        //로그인 상태인가?

        //이미 로그인 상태라면? -> index로 redirect
        return "/login/login";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Message> login(Member member) {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json"));
        MessageWrapper messageWrapper = loginService.getHttpMessage(member);
        ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message(messageWrapper.getMessage()), header, messageWrapper.getHttpStatus());
        return responseEntity;

    }


}
