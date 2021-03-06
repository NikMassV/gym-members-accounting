package edu.nikitaMaistrenko.dao;

import edu.nikitaMaistrenko.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m from Member m where m.lastName = ?1")
    List<Member> findByLastName(String lastName);

    @Query(value = "select m from Member m where m.lastName = ?1 and m.firstName = ?2")
    Member findByLastNameAndFirstName(String lastName, String firstMame);
}
