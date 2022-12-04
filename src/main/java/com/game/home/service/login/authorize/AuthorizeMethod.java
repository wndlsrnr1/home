package com.game.home.service.login.authorize;

import com.game.home.data.member.Member;
import com.game.home.service.login.message.MessageEnum;

public interface AuthorizeMethod {

    MessageEnum authorize(Member member);
}
