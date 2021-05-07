package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MembershipGYMRepository;
import edu.nikitaMaistrenko.domain.MembershipGYM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembershipGYMService {

    private final MembershipGYMRepository membershipGYMRepository;


    public MembershipGYMService(MembershipGYMRepository membershipGYMRepository) {
        this.membershipGYMRepository = membershipGYMRepository;
    }

    @Transactional
    public void add(MembershipGYM membershipGYM) {
        MembershipGYM savedMembershipGYM = membershipGYMRepository.saveAndFlush(membershipGYM);
    }

    @Transactional
    public MembershipGYM findByTypeOfMembershipGYM(String typeOfMembershipGYM) {
        return membershipGYMRepository.findByTypeOfMembershipGYM(typeOfMembershipGYM);
    }

    @Transactional
    public List<MembershipGYM> findAllMembershipsOfGYM() {
        return membershipGYMRepository.findAll();
    }

    @Transactional
    public MembershipGYM editMembershipGYM(MembershipGYM membershipGYM) {
        return membershipGYMRepository.saveAndFlush(membershipGYM);
    }
}
