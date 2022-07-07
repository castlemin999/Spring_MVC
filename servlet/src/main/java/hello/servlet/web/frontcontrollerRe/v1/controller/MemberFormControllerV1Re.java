package hello.servlet.web.frontcontrollerRe.v1.controller;

import hello.servlet.web.frontcontrollerRe.v1.ControllerV1Re;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1Re implements ControllerV1Re {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/new-form.jsp");
        dispatcher.forward(request, response);
    }
}
