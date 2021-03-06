package hello.servlet.web.springmvcRe.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberFormControllerV1Re {

    @RequestMapping("/springmvc-re/v1/members/new-form")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("new-form");
    }

}
