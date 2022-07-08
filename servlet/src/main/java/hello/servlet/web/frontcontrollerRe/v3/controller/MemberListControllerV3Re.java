package hello.servlet.web.frontcontrollerRe.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.v3.ControllerV3Re;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3Re implements ControllerV3Re {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelViewRe process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelViewRe mv = new ModelViewRe("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
