package hello.servlet.web.frontcontrollerRe.v4.controller;

import hello.servlet.web.frontcontrollerRe.v4.ControllerV4Re;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MemberFormControllerV4Re implements ControllerV4Re {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }

}
