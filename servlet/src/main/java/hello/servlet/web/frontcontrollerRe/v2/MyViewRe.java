package hello.servlet.web.frontcontrollerRe.v2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;

public class MyViewRe {
    private String viewPath;

    public MyViewRe(String viewPath) {
        this.viewPath = viewPath;
    }

    void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
