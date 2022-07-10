package hello.servlet.web.frontcontrollerRe.v5;

import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.MyViewRe;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberFormControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberListControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v3.controller.MemberSaveControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberFormControllerV4Re;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberListControllerV4Re;
import hello.servlet.web.frontcontrollerRe.v4.controller.MemberSaveControllerV4Re;
import hello.servlet.web.frontcontrollerRe.v5.adapter.ControllerV3HandlerAdapterRe;
import hello.servlet.web.frontcontrollerRe.v5.adapter.ControllerV4HandlerAdapterRe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5Re", urlPatterns = "/front-controller-re/v5/*")
public class FrontControllerV5Re extends HttpServlet {

    Map<String, Object> handlerMap = new HashMap<>();
    List<MyHandlerAdapterRe> handlerAdapterList = new ArrayList<>();

    public FrontControllerV5Re() {
        initHandlerMapping();
        initHandlerAdapterListMapping();
    }

    private void initHandlerMapping() {
        handlerMap.put("/front-controller-re/v5/v3/members/new-form", new MemberFormControllerV3Re());
        handlerMap.put("/front-controller-re/v5/v3/members/save", new MemberSaveControllerV3Re());
        handlerMap.put("/front-controller-re/v5/v3/members", new MemberListControllerV3Re());

        handlerMap.put("/front-controller-re/v5/v4/members/new-form", new MemberFormControllerV4Re());
        handlerMap.put("/front-controller-re/v5/v4/members/save", new MemberSaveControllerV4Re());
        handlerMap.put("/front-controller-re/v5/v4/members", new MemberListControllerV4Re());
    }

    private void initHandlerAdapterListMapping() {
        handlerAdapterList.add(new ControllerV3HandlerAdapterRe());
        handlerAdapterList.add(new ControllerV4HandlerAdapterRe());
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Object handler = handlerMap.get(requestURI);

        MyHandlerAdapterRe handlerAdapter = getHandlerAdapter(handler);
        ModelViewRe mv = handlerAdapter.handle(request, response, handler);

        MyViewRe view = viewResolver(mv.getViewName());

        view.render(request, response, mv.getModel());
    }

    private MyHandlerAdapterRe getHandlerAdapter(Object handler) {
        for (MyHandlerAdapterRe adapter : handlerAdapterList) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("adapter가 존재하지 않습니다. handler = " + handler);
    }

    private MyViewRe viewResolver(String viewName) {
        String viewPath = "/WEB-INF/views/" + viewName + ".jsp";
        return new MyViewRe(viewPath);
    }
}
