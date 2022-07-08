package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV2HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV2;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV2 controller = (ControllerV2) handler;
        MyView view = controller.process(request, response);
        String viewName = getViewName(view);

        ModelView mv = new ModelView(viewName);

        Map<String, Object> model = getModelFromRequest(request);

        mv.setModel(model);
        return mv;
    }

    private Map<String, Object> getModelFromRequest(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        request.getAttributeNames().asIterator()
                .forEachRemaining(attrName -> model.put(attrName, request.getAttribute(attrName)));
        return model;
    }

    private String getViewName(MyView view) {
        String viewPath = view.getViewPath();
        String viewName = viewPath.substring(viewPath.lastIndexOf("/") + 1, viewPath.lastIndexOf("."));
        return viewName;
    }

}
