package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.MembershipCard;
import edu.nikitaMaistrenko.view.MembershipCardResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member left join mc.membershipGYM")
    List<MembershipCardResponse> findAllMembershipCards();

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member left join mc.membershipGYM " +
            "where mc.member.lastName = ?1")
    List<MembershipCardResponse> findByLastName(String lastName);

    @Query(value = "select new edu.nikitaMaistrenko.view.MembershipCardResponse(mc.member.lastName, mc.member.firstName, " +
            "mc.membershipGYM.typeOfMembershipGYM, mc.markedWorkouts, mc.expiredDate, mc.purchaseDate) " +
            "from MembershipCard mc left join mc.member left join mc.membershipGYM " +
            "where mc.member.lastName = ?1 and mc.member.firstName = ?2")
    List<MembershipCardResponse> findByLastNameAndFirstName(String lastName, String firstName);

    @Query(value = "from MembershipCard mc inner join fetch mc.member inner join fetch mc.membershipGYM")
    List<MembershipCard> findAllFullData();
}
