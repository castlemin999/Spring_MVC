package hello.servlet.web.frontcontrollerRe.v3.controller;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.v3.ControllerV3Re;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3Re implements ControllerV3Re {

    @Override
    public ModelViewRe process(Map<String, String> paramMap) throws ServletException, IOException {
        return new ModelViewRe("new-form");
    }

}
