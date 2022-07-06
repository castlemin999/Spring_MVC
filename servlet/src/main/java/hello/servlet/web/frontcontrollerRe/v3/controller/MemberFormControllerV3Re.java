package hello.servlet.web.frontcontrollerRe.v3.controller;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.v3.ControllerV3Re;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MemberFormControllerV3Re implements ControllerV3Re {
    @Override
    public ModelViewRe process(Map<String, String> paramMap) {
        return new ModelViewRe("new-form");
    }
}
