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

    @GetMapping(path = "/findAllMembershipCards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipCardResponse> findAllMembershipCards(){
        return membershipCardService.findAllMembershipCards();
    }
}
