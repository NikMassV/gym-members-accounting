package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MemberRepository;
import edu.nikitaMaistrenko.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Transactional
    public void add(Member member) {
        Member savedMember = memberRepository.saveAndFlush(member);
    }

    @Transactional
    public Member findByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    @Transactional
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }


    @Transactional
    public Member editMembershipGYM(Member member) {
        return memberRepository.saveAndFlush(member);
    }
}
