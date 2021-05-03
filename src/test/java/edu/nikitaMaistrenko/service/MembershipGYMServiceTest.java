package edu.nikitaMaistrenko.service;

import edu.nikitaMaistrenko.domain.MembershipGYM;
import org.junit.Assert;
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

import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:gym_members_ddl_and_dml.sql")})
public class MembershipGYMServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(MembershipGYMServiceTest.class);

    @Autowired
    private MembershipGYMService membershipGYMService;


    @InjectMocks
    MembershipGYM membershipGYM = new MembershipGYM();


    @Test
    public void add() {
        membershipGYM.setTypeOfGymMembership("ULT6");
        membershipGYM.setNumber_of_workouts(76);
        membershipGYM.setValidityMonths(6);
        membershipGYMService.add(membershipGYM);
        List<MembershipGYM> list = membershipGYMService.findAllMemberships();
        LOG.info("add - OK");
        Assert.assertTrue(list.size() == 2);
    }

    @Test
    public void findByTypeOfGymMembership() {
        MembershipGYM membershipGYM = membershipGYMService.findByTypeOfGymMembership("ULT1");
        LOG.info("findByTypeOfGymMembership - OK");
        Assert.assertTrue(membershipGYM.getTypeOfGymMembership().equals("ULT1"));
    }

    @Test
    public void findAll() {
        List<MembershipGYM> list = membershipGYMService.findAllMemberships();
        LOG.info("findAll - OK");
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void editMembershipGYM() {
        MembershipGYM membershipGYM = membershipGYMService.findByTypeOfGymMembership("ULT1");
        membershipGYM.setTypeOfGymMembership("ULT2");
        membershipGYM.setValidityMonths(2);
        membershipGYM.setNumber_of_workouts(32);
        MembershipGYM edited = membershipGYMService.editMembershipGYM(membershipGYM);
        LOG.info("editMembershipGYM - OK");
        Assert.assertTrue(edited.getTypeOfGymMembership().equals("ULT2"));
        Assert.assertTrue(edited.getValidityMonths() == 2);
        Assert.assertTrue(edited.getNumber_of_workouts() == 32);
    }
}
