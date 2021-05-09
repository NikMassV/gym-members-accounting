package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.MembershipCard;
import edu.nikitaMaistrenko.view.MembershipCardResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member on mc.member = mc.member.memberId " +
            "left join mc.membershipGYM on mc.membershipGYM = mc.membershipGYM.gymMembershipId")
    List<MembershipCardResponse> findAllMembershipCards();

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member on mc.member = mc.member.memberId " +
            "left join mc.membershipGYM on mc.membershipGYM = mc.membershipGYM.gymMembershipId " +
            "where mc.member.lastName = ?1")
    List<MembershipCardResponse> findByLastName(String lastName);

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member on mc.member = mc.member.memberId " +
            "left join mc.membershipGYM on mc.membershipGYM = mc.membershipGYM.gymMembershipId " +
            "where mc.member.lastName = ?1 and mc.member.firstName = ?2")
    List<MembershipCardResponse> findByLastNameAndFirstName(String lastName, String firstName);
}
