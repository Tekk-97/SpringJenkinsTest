package com.example.SpringJenkinsTest.controller;

import com.example.SpringJenkinsTest.domain.Member;
import com.example.SpringJenkinsTest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

//    @GetMapping("/yourstatus")
//    public String returnstat(Model model) throws UnknownHostException {
//        System.out.println(InetAddress.getLocalHost().getHostName());
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
//
//
//        //List<Member> members = memberService.findMembers();
//        model.addAttribute("mystat", InetAddress.getLocalHost().getHostName()+"   "+
//                InetAddress.getLocalHost().getHostAddress()+"   "+ InetAddress.getLocalHost().getCanonicalHostName());
//
//        return "home";
//    }
}
