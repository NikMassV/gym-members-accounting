package edu.nikitaMaistrenko.rest;

import edu.nikitaMaistrenko.domain.Member;
import edu.nikitaMaistrenko.domain.MembershipCard;
import edu.nikitaMaistrenko.domain.MembershipGYM;
import edu.nikitaMaistrenko.domain.MembershipStatus;
import edu.nikitaMaistrenko.service.MemberService;
import edu.nikitaMaistrenko.service.MembershipCardService;
import edu.nikitaMaistrenko.service.MembershipGYMService;
import edu.nikitaMaistrenko.view.MembershipCardRequest;
import edu.nikitaMaistrenko.view.MembershipCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/membershipCard")
public class MembershipCardController {

    private MembershipCardService membershipCardService;
    private MemberService memberService;
    private MembershipGYMService membershipGYMService;

    public MembershipCardController(MembershipCardService membershipCardService, MemberService memberService, MembershipGYMService membershipGYMService) {
        this.membershipCardService = membershipCardService;
        this.memberService = memberService;
        this.membershipGYMService = membershipGYMService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody MembershipCardRequest membershipCardRequest) {
        MembershipGYM membershipGYM = membershipGYMService.findByTypeOfMembershipGYM(membershipCardRequest.getTypeOfMembershipGYM());
        if (membershipGYM == null) return "This membership of GYM doesn`t exist";

        Member member = memberService.findByLastNameAndFirstName(membershipCardRequest.getLastName(),
                membershipCardRequest.getFirstName());
        if (member == null) return "This member doesn`t exist";


        MembershipCard membershipCard = new MembershipCard();
        membershipCard.setMember(member);
        membershipCard.setMembershipGYM(membershipGYM);
        membershipCard.setMarkedWorkouts(1);
        membershipCard.setPurchaseDate(LocalDate.now());
        membershipCard.setExpiredDate(LocalDate.now().plusMonths(membershipGYM.getValidityMonths()).minusDays(1));
        membershipCard.setMembershipStatus(MembershipStatus.АКТИВНЫЙ);
        membershipCardService.add(membershipCard);

        return "Membership card added successfully!";
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipCardResponse> findAllMembershipCards() {
        return membershipCardService.findAllMembershipCards();
    }

    @GetMapping(path = "/findByLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipCardResponse> findByLastName(@RequestParam("lastName") String lastName) {
        return membershipCardService.findByLastName(lastName);
    }

    @GetMapping(path = "/findByLastNameAndFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipCardResponse> findByLastNameAndFirstName(@RequestParam("lastName") String lastName,
                                                                   @RequestParam("firstName") String firstName) {
        return membershipCardService.findByLastNameAndFirstName(lastName, firstName);
    }

    @GetMapping(path = "/findAllFullData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipCard> findAllFullData() {
        return membershipCardService.findAllFullData();
    }
}
