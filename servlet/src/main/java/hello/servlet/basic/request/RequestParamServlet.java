package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
*/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * request.getParameter 메서드는 GET, POST 로 요청한 값을 다 꺼낼수 있다.
        * GET은 HTTP 헤더에 쿼리 파라미터로 담고,
        * POST는 HTTP 메시지에 쿼리 파라미터로 담아 서버에 전송.
        * 서버 입장에서는 똑같은 형식의 데이터로 받기 때문에 request.getParameter로 구분없이 조회가 가능하다.
        * */

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        // 복수로 존재하면 첫번째 값만 가져옴
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");


    }
}
