package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//this is annotation
@WebServlet("/request")
public class Request extends HttpServlet {
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
        throws ServletException , IOException{
        res.setContentType("text/html");

        req.setAttribute("name","Ajay");//it takes key value pair

        PrintWriter out =  res.getWriter();

        String name = (String)(req.getAttribute("name"));

        out.println("<h1>request: %s</h1>".formatted(name));
    }
}
