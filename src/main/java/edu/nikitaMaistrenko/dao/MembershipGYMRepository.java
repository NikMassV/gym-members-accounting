package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.MembershipGYM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MembershipGYMRepository extends JpaRepository<MembershipGYM, Long> {

    @Query(value = "select t from MembershipGYM t where t.typeOfMembershipGYM = ?1")
    MembershipGYM findByTypeOfMembershipGYM(String typeOfMembershipGYM);
}
