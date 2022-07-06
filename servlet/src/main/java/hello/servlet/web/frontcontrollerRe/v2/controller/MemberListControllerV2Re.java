package hello.servlet.web.frontcontrollerRe.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontrollerRe.v2.ControllerV2Re;
import hello.servlet.web.frontcontrollerRe.MyViewRe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2Re implements ControllerV2Re {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyViewRe process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        return new MyViewRe("/WEB-INF/views/members.jsp");
    }
}
