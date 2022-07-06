package hello.servlet.web.frontcontrollerRe.v2.controller;

import hello.servlet.web.frontcontrollerRe.v2.ControllerV2Re;
import hello.servlet.web.frontcontrollerRe.v2.MyViewRe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2Re implements ControllerV2Re {
    @Override
    public MyViewRe process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyViewRe("/WEB-INF/views/new-form.jsp");
    }
}
