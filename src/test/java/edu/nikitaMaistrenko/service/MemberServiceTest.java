package edu.nikitaMaistrenko.service;


import edu.nikitaMaistrenko.domain.Member;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:gym_members_ddl_and_dml.sql")})
public class MemberServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceTest.class);

    @Autowired
    private MemberService memberService;


    @InjectMocks
    Member member = new Member();


    @Test
    public void add() {
        member.setFirstName("Петр");
        member.setLastName("Гончарук");
        member.setDateOfBirth(LocalDate.of(1995, 9, 15));
        member.setTelNumber("+375(29)385-24-43");
        member.setSex("мужской");
        member.setSourceOfAdvertising("facebook");
        memberService.add(member);
        List<Member> list = memberService.findAllMembers();
        LOG.info("add - OK");
        Assert.assertTrue(list.size() == 3);
    }


    @Test
    public void findByLastName() {
        List<Member> list = memberService.findByLastName("Простанина");
        LOG.info("findByLastName - OK");
        list.forEach(m -> System.err.println(m.getFirstName()));
        //Assert.assertTrue(list.equals("Простанина"));
    }

    @Test
    public void findAllMembers() {
        List<Member> list = memberService.findAllMembers();
        LOG.info("findAllMembers - OK");
        Assert.assertTrue(list.size() == 2);
    }

/*
    @Test
    public void editMembershipGYM() {
        List<Member> member = memberService.findByLastName("Васильев");
        member.setFirstName("Анатолий");
        member.setLastName("Самсонов");
        member.setDateOfBirth(LocalDate.of(1995, 9, 15));
        member.setTelNumber("+375(29)385-24-43");
        member.setSex("мужской");
        member.setSourceOfAdvertising("facebook");
        Member edited = memberService.editMembershipGYM(member);
        LOG.info("editMembershipGYM - OK");
        Assert.assertTrue(edited.getLastName().equals("Самсонов"));
    }*/
}
