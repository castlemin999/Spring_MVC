package hello.servlet.web.frontcontrollerRe.v4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ControllerV4Re {
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
