package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MembershipCardRepository;
import edu.nikitaMaistrenko.domain.Member;
import edu.nikitaMaistrenko.domain.MembershipCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembershipCardService {

    private final MembershipCardRepository membershipCardRepository;

    @Autowired
    public MembershipCardService(MembershipCardRepository membershipCardRepository) {
        this.membershipCardRepository = membershipCardRepository;
    }

    @Transactional
    public void add(MembershipCard membershipCard) {
        MembershipCard savedMembershipCard = membershipCardRepository.saveAndFlush(membershipCard);
    }

    @Transactional
    public List<MembershipCard> findByLastName(Member member) {
        return  membershipCardRepository.findByMemberLastName(member.getLastName());
    }

    @Transactional
    public List<MembershipCard> findAllMembershipCards() {
        return  membershipCardRepository.findAllMembershipCards();
    }
}
