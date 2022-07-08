package hello.servlet.web.frontcontrollerRe.v3;

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

@WebServlet(name = "frontControllerV3Re", urlPatterns = "/front-controller-re/v3/*")
public class FrontControllerV3Re extends HttpServlet {

    Map<String, ControllerV3Re> controllerMap = new HashMap<>();

    public FrontControllerV3Re() {
        controllerMap.put("/front-controller-re/v3/members/new-form", new MemberFormControllerV3Re());
        controllerMap.put("/front-controller-re/v3/members/save", new MemberSaveControllerV3Re());
        controllerMap.put("/front-controller-re/v3/members", new MemberListControllerV3Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3Re controller = controllerMap.get(requestURI);

        Map<String, String> paramMap = createParamMap(request);
        ModelViewRe mv = controller.process(paramMap);

        MyViewRe view = viewResolver(mv);

        view.render(request, response, mv.getModel());
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private MyViewRe viewResolver(ModelViewRe mv) {
        String viewPath = "/WEB-INF/views/" + mv.getViewName() + ".jsp";
        return new MyViewRe(viewPath);
    }
}
