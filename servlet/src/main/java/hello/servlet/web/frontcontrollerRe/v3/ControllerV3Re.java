package hello.servlet.web.frontcontrollerRe.v3;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;

import java.util.Map;

public interface ControllerV3Re {
    ModelViewRe process(Map<String, String> paramMap);
}
