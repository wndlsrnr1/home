package com.game.home.repository;

import com.game.home.data.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    Member join(Member member);

    List<Member> findAll();

    Member findOne();

    boolean isAlreadyEmail();

    boolean isAlreadyId();

    Member findByIdAndPassword(String id, String password);
}
