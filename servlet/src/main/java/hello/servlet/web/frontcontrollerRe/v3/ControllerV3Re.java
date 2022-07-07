package hello.servlet.web.frontcontrollerRe.v3;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3Re {
    ModelViewRe process(Map<String, String> paramMap) throws ServletException, IOException;
}
