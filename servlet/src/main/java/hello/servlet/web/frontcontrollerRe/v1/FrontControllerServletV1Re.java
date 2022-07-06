package hello.servlet.web.frontcontrollerRe.v1;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontrollerRe.v1.controller.MemberFormControllerV1Re;
import hello.servlet.web.frontcontrollerRe.v1.controller.MemberListControllerV1Re;
import hello.servlet.web.frontcontrollerRe.v1.controller.MemberSaveControllerV1Re;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1Re", urlPatterns = "/front-controller-re/v1/*")
public class FrontControllerServletV1Re extends HttpServlet {
    Map<String, ControllerV1Re> controllerMap = new HashMap<>();

    public FrontControllerServletV1Re() {
        controllerMap.put("/front-controller-re/v1/members/new-form", new MemberFormControllerV1Re());
        controllerMap.put("/front-controller-re/v1/members/save", new MemberSaveControllerV1Re());
        controllerMap.put("/front-controller-re/v1/members", new MemberListControllerV1Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV1Re controller = controllerMap.get(requestURI);
        controller.process(request, response);
    }
}
