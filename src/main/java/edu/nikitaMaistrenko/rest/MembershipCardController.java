package edu.nikitaMaistrenko.rest;

import edu.nikitaMaistrenko.domain.MembershipCard;
import edu.nikitaMaistrenko.service.MembershipCardService;
import edu.nikitaMaistrenko.view.MembershipCardResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/membershipCard")
public class MembershipCardController {

    MembershipCardService membershipCardService;

    public MembershipCardController(MembershipCardService membershipCardService) {
        this.membershipCardService = membershipCardService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody MembershipCard membershipCard) {
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
