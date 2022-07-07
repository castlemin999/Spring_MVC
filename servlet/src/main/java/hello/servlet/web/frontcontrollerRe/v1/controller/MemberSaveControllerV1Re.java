package hello.servlet.web.frontcontrollerRe.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontrollerRe.v1.ControllerV1Re;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1Re implements ControllerV1Re {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        request.setAttribute("member", member);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/save-result.jsp");
        dispatcher.forward(request, response);
    }
}
