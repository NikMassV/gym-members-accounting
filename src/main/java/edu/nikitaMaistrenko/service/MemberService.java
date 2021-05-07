package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MemberRepository;
import edu.nikitaMaistrenko.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Transactional
    public void add(Member member) {
        Member savedMember = memberRepository.saveAndFlush(member);
    }

    @Transactional
    public List<Member> findByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    @Transactional
    public Member findByLastNameAndFirstName(String lastName, String firstName) {
        return memberRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Transactional
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public Member editMember(Member member) {
        return memberRepository.saveAndFlush(member);
    }
}
