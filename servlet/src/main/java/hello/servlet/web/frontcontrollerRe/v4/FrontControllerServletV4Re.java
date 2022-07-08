package hello.servlet.web.frontcontrollerRe.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.MyViewRe;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberFormControllerV4Re;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberListControllerV4Re;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberSaveControllerV4Re;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4Re", urlPatterns = "/front-controller-re/v4/*")
public class FrontControllerServletV4Re extends HttpServlet {

    Map<String, ControllerV4Re> controllerMap = new HashMap<>();

    public FrontControllerServletV4Re() {
        controllerMap.put("/front-controller-re/v4/members/new-form", new MemberFormControllerV4Re());
        controllerMap.put("/front-controller-re/v4/members/save", new MemberSaveControllerV4Re());
        controllerMap.put("/front-controller-re/v4/members", new MemberListControllerV4Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV4Re controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);
        MyViewRe view = viewResolver(viewName);
        view.render(request, response, model);

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }



    private MyViewRe viewResolver(String viewName) {
        String viewPath = "/WEB-INF/views/" + viewName + ".jsp";
        return new MyViewRe(viewPath);
    }
}
