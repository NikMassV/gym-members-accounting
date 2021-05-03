package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.MembershipCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {

    @Query(value = "select mc from MembershipCard mc left join fetch mc.member left join fetch mc.membershipGYM")
    List<MembershipCard> findAllMembershipCards();

    @Query(value = "")
    List<MembershipCard> findByMemberLastName(String lastName);

}
