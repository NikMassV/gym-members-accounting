package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m from Member m where m.lastName = ?1")
    Member findByLastName(String typeOfGymMembership);
}
