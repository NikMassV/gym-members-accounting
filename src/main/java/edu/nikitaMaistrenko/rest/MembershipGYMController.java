package edu.nikitaMaistrenko.rest;

import edu.nikitaMaistrenko.domain.MembershipGYM;
import edu.nikitaMaistrenko.service.MembershipGYMService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/membershipGYM")
public class MembershipGYMController {

    private MembershipGYMService membershipGYMService;

    public MembershipGYMController(MembershipGYMService membershipGYMService) {
        this.membershipGYMService = membershipGYMService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addMembershipGYM(@RequestBody MembershipGYM membershipGYM) {
        membershipGYMService.add(membershipGYM);
        return "MembershipGYM added successfully!";
    }

    @GetMapping(path = "/findByType", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MembershipGYM findByTypeOfMembershipGYM(@RequestParam("typeOfMembershipGYM") String typeOfMembershipGYM) {
        return membershipGYMService.findByTypeOfMembershipGYM(typeOfMembershipGYM);
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MembershipGYM> findAllMembershipsOfGYM() {
        return membershipGYMService.findAllMembershipsOfGYM();
    }

    @PutMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MembershipGYM editMembershipGYM(@RequestBody MembershipGYM membershipGYM) {
        return membershipGYMService.editMembershipGYM(membershipGYM);
    }
}
