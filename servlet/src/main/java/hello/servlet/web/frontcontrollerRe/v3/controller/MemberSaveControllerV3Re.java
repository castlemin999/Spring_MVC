package hello.servlet.web.frontcontrollerRe.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.v3.ControllerV3Re;

import java.util.Map;

public class MemberSaveControllerV3Re implements ControllerV3Re {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelViewRe process(Map<String, String> paramMap) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelViewRe mv = new ModelViewRe("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
