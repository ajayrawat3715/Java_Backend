package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request1")
public class Request1 extends HttpServlet {
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException , IOException{
        res.setContentType("text/html");

        PrintWriter out =  res.getWriter();

        String name = (String)(req.getAttribute("name"));

        HttpSession session = req.getSession();

        String id = (String) session.getAttribute("Id");

       out.println("<h1>request: %s</h1>".formatted(name));
        out.println("<h1>request: %s</h1>".formatted(id));
    }
}
