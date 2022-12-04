package com.game.home.repository;

import com.game.home.data.member.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member join(Member member) {
        member.setId(++sequence);
        members.put(member.getId(), member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        ArrayList<Member> memberList = new ArrayList<>();
        for (Member value : members.values()) {
            memberList.add(value);
        }
        return memberList;
    }

    @Override
    public Member findOne() {
        return null;
    }

    @Override
    public boolean isAlreadyEmail() {
        return false;
    }

    @Override
    public boolean isAlreadyId() {
        return false;
    }
}
