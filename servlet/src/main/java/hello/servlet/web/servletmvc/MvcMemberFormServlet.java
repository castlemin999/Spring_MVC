package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // Controller를 거쳐서 보여지는 JSP 파일은 WEB-INF 폴더에 만들어야함 (WAS에서 정한 규칙)
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// Controller에서 view로 이동
        dispatcher.forward(request, response); // 서버 안에서 내부적으로 화면까지 생성해서 클라이언트에 전달

    }
}
