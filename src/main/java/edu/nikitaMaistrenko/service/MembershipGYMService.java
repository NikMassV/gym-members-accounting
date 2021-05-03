package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MembershipGYMRepository;
import edu.nikitaMaistrenko.domain.MembershipGYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembershipGYMService {

    private final MembershipGYMRepository membershipGYMRepository;

    @Autowired
    public MembershipGYMService(MembershipGYMRepository membershipGYMRepository) {
        this.membershipGYMRepository = membershipGYMRepository;
    }

    @Transactional
    public void add(MembershipGYM membershipGYM) {
        MembershipGYM savedMembershipGYM = membershipGYMRepository.saveAndFlush(membershipGYM);
    }

    @Transactional
    public MembershipGYM findByTypeOfGymMembership(String typeOfGymMembership) {
        return membershipGYMRepository.findByTypeOfGymMembership(typeOfGymMembership);
    }

    @Transactional
    public List<MembershipGYM> findAllMemberships() {
        return membershipGYMRepository.findAll();
    }

    @Transactional
    public MembershipGYM editMembershipGYM(MembershipGYM membershipGYM) {
        return membershipGYMRepository.saveAndFlush(membershipGYM);
    }
}
