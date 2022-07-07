package hello.servlet.web.frontcontrollerRe.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontrollerRe.ModelViewRe;
import hello.servlet.web.frontcontrollerRe.MyViewRe;
import hello.servlet.web.frontcontrollerRe.v3.ControllerV3Re;
import hello.servlet.web.frontcontrollerRe.v5.MyHandlerAdapterRe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapterRe implements MyHandlerAdapterRe {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3Re);
    }

    @Override
    public ModelViewRe handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV3Re controller = (ControllerV3Re) handler;
        Map<String, String> paramMap = createParamMap(request);

        ModelViewRe mv = controller.process(paramMap);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
