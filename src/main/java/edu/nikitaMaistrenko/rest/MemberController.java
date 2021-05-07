package edu.nikitaMaistrenko.rest;


import edu.nikitaMaistrenko.domain.Member;
import edu.nikitaMaistrenko.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addMember(@RequestBody Member member) {
        memberService.add(member);
        return "Member added successfully";
    }

    @GetMapping(path = "/findByLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Member> findByLastName(@RequestParam("lastName") String lastName) {
        return memberService.findByLastName(lastName);
    }

    @GetMapping(path = "/findByLastNameAndFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Member findByLastNameAndFirstName(@RequestParam("lastName") String lastName,
                                             @RequestParam("firstName") String firstName) {
        return memberService.findByLastNameAndFirstName(lastName, firstName);
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Member> findAllMembers() {
        return memberService.findAllMembers();
    }

    @PutMapping(path = "/editMember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Member editMember(@RequestBody Member member) {
        return memberService.editMember(member);
    }
}
