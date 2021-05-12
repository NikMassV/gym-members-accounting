package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.dao.MembershipCardRepository;
import edu.nikitaMaistrenko.domain.MembershipCard;
import edu.nikitaMaistrenko.view.MembershipCardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembershipCardService {

    private final MembershipCardRepository membershipCardRepository;


    public MembershipCardService(MembershipCardRepository membershipCardRepository) {
        this.membershipCardRepository = membershipCardRepository;
    }

    @Transactional
    public void add(MembershipCard membershipCard) {
        MembershipCard savedMembershipCard = membershipCardRepository.saveAndFlush(membershipCard);
    }

    @Transactional
    public List<MembershipCardResponse> findByLastName(String lastName) {
        return membershipCardRepository.findByLastName(lastName);
    }

    @Transactional
    public List<MembershipCardResponse> findByLastNameAndFirstName(String lastName, String firstName) {
        return membershipCardRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Transactional
    public List<MembershipCardResponse> findAllMembershipCards() {
        return membershipCardRepository.findAllMembershipCards();
    }

    @Transactional
    public List<MembershipCard> findAllFullData(){
        return membershipCardRepository.findAllFullData();
    }
}
