package hello.servlet.web.frontcontrollerRe;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelViewRe {
    private String viewPath;
    private Map<String, Object> model = new HashMap<>();

    public ModelViewRe(String viewPath) {
        this.viewPath = viewPath;
    }
}
