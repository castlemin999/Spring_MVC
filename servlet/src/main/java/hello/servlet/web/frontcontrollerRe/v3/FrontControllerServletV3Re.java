package hello.servlet.web.frontcontrollerRe.v3;

import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.MyViewRe;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberFormControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberListControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberSaveControllerV3Re;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3Re", urlPatterns = "/front-controller-re/v3/*")
public class FrontControllerServletV3Re extends HttpServlet {

    private Map<String, ControllerV3Re> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3Re() {
        controllerV3Map.put("/front-controller-re/v3/members/new-form", new MemberFormControllerV3Re());
        controllerV3Map.put("/front-controller-re/v3/members/save", new MemberSaveControllerV3Re());
        controllerV3Map.put("/front-controller-re/v3/members", new MemberListControllerV3Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3Re controller = controllerV3Map.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelViewRe mv = controller.process(paramMap);
        MyViewRe view = viewResolver(mv);

        view.render(mv.getModel(), request, response);
    }

    private MyViewRe viewResolver(ModelViewRe mv) {
        String viewPath = "/WEB-INF/views/" + mv.getViewPath() + ".jsp";
        MyViewRe view = new MyViewRe(viewPath);
        return view;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
