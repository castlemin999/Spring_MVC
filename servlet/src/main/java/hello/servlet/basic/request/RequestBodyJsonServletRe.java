package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import hello.servlet.domain.member.Member;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(name="requestBodyJsonServletRe", urlPatterns = "/request-body-json-re")
public class RequestBodyJsonServletRe extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        String username = helloData.getUsername();
        int age = helloData.getAge();

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        response.getWriter().write("ok");

    }
}
