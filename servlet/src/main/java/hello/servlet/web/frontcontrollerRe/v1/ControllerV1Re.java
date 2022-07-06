package hello.servlet.web.frontcontrollerRe.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1Re {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
