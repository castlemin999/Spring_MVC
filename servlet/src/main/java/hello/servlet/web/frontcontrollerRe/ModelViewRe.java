package hello.servlet.web.frontcontrollerRe;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class ModelViewRe {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelViewRe(String viewName) {
        this.viewName = viewName;
    }

}
