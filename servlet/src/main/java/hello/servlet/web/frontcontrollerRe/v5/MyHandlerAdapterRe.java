package hello.servlet.web.frontcontrollerRe.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapterRe {

    boolean supports(Object handler);

    ModelViewRe handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
