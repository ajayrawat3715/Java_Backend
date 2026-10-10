package in.coderarmy;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generic")
public class Generic extends GenericServlet {
    @Override
    public void service(ServletRequest req,
                        ServletResponse res)
            throws ServletException , IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        
        out.println("<h1>Hello from Generic servlet</h1>");
    }
}
