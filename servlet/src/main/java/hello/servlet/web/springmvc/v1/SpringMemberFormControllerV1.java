package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*

* RequestMappingHandlerMapping : 처리할 Handler(Controller)가 있는지 조회
* RequestMappingHandlerAdapter : Handler(Controller)를 처리할 Adapter가 있는지 조회
*
* @Component
* @RequestMapping
* class 레벨에 @RequestMapping 애노테이션이 있으면 RequestMappingHandlerMapping에서 Handler로 인식
*
* */

// @Controller 애노테이션은 RequestMappingHandlerMapping에서 Handler로 인식함
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
