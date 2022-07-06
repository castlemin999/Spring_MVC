package hello.servlet.web.frontcontrollerRe.v2;

import hello.servlet.web.frontcontrollerRe.v2.ControllerV2Re;
import hello.servlet.web.frontcontrollerRe.v2.MyViewRe;
import hello.servlet.web.frontcontrollerRe.v2.controller.MemberFormControllerV2Re;
import hello.servlet.web.frontcontrollerRe.v2.controller.MemberListControllerV2Re;
import hello.servlet.web.frontcontrollerRe.v2.controller.MemberSaveControllerV2Re;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2Re", urlPatterns = "/front-controller-re/v2/*")
public class FrontControllerServletV2Re extends HttpServlet {
    Map<String, ControllerV2Re> controllerV2ReMap = new HashMap<>();

    public FrontControllerServletV2Re() {
        controllerV2ReMap.put("/front-controller-re/v2/members/new-form", new MemberFormControllerV2Re());
        controllerV2ReMap.put("/front-controller-re/v2/members/save", new MemberSaveControllerV2Re());
        controllerV2ReMap.put("/front-controller-re/v2/members", new MemberListControllerV2Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV2Re controller = controllerV2ReMap.get(requestURI);
        MyViewRe view = controller.process(request, response);
        view.render(request, response);
    }
}
