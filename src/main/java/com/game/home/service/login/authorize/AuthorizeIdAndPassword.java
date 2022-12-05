package com.game.home.service.login.authorize;

import com.game.home.data.member.Member;
import com.game.home.data.status.Message;
import com.game.home.repository.MemberRepository;
import com.game.home.service.login.message.MessageEnum;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeIdAndPassword implements AuthorizeMethod{
    private final MemberRepository memberRepository;

    public AuthorizeIdAndPassword(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MessageEnum authorize(Member member) {
        Member findMember = memberRepository.findByIdAndPassword(member.getId(), member.getPassword());
        if (findMember == null){
            return MessageEnum.UNAUTHORIZED;
        }
        return MessageEnum.VALID_SEQUENCE;
    }

}
