package edu.nikitaMaistrenko.rest;


import edu.nikitaMaistrenko.domain.Member;
import edu.nikitaMaistrenko.service.MemberService;
import edu.nikitaMaistrenko.view.MemberRequest;
import edu.nikitaMaistrenko.view.MemberResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(path = "/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Member> findByLastName(@PathVariable("lastName") String lastName) {

        List<Member> findedMember = memberService.findByLastName(lastName);

        return findedMember;
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Member> findAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping(path = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public String cA() {
        return "Rest is working";
    }
}
