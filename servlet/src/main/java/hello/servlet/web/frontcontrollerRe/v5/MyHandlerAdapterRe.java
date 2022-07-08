package hello.servlet.web.frontcontrollerRe.v5;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.MyViewRe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapterRe {
    boolean supports(Object handler);

    ModelViewRe handle(HttpServletRequest request, HttpServletResponse response, Object handler);

}
