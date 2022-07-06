package hello.servlet.web.frontcontrollerRe.v2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2Re {
    MyViewRe process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
