package com.game.home.repository;

import com.game.home.data.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
@Slf4j
public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();
    private static long sequence = 0L;

    public MemoryMemberRepository() {
        Member member = new Member("wndlsrnr1", "주인국", "1236713265!a", "wndlsrnr1@naver.com", "우리집", "20121212", "20111212");
        members.put(1L, member);
        Member member1 = new Member("wndlsrnr2", "주인국", "1236713265!a", "wndlsrnr1@naver.com", "우리집", "20121212", "20111212");
        members.put(1L, member);
        Member member2 = new Member("wndlsrnr3", "주인국", "1236713265!a", "wndlsrnr1@naver.com", "우리집", "20121212", "20111212");
        members.put(1L, member);
        Member member3 = new Member("wndlsrnr4", "주인국", "1236713265!a", "wndlsrnr1@naver.com", "우리집", "20121212", "20111212");
        members.put(1L, member);
        Member member4 = new Member("wndlsrnr5", "주인국", "1236713265!a", "wndlsrnr1@naver.com", "우리집", "20121212", "20111212");
        members.put(1L, member);
    }

    @Override
    public Member join(Member member) {
        member.setUnique(++sequence);
        members.put(member.getUnique(), member);
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

    @Override
    public Member findByIdAndPassword(String id, String password) {
        log.info("memberMap = {}", members);
        for (Long key : members.keySet()) {
            Member member = members.get(key);
            if (member.getId().equals(id) && member.getPassword().equals(password)){
                return member;
            }
        }
        return null;
    }
}
