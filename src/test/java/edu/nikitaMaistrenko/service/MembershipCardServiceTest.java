package edu.nikitaMaistrenko.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:gym_members_migration.sql")})
public class MembershipCardServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(MembershipGYMServiceTest.class);

    @Autowired
    private MembershipCardService membershipCardService;


    @Test
    public void findAll() {
        /*List<MembershipCard> list = membershipCardService.findAllMembershipCards();
        list.forEach(mc -> System.out.println(mc.getMembershipCardId() + " : " + mc.getMember() + " : " + mc.getMembershipGYM()));
        LOG.info("findAll - OK");*/
    }
}
