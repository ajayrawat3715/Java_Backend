package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class Service extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse res)
        throws ServletException , IOException{
        res.setContentType("text/html"); //html text response mein dena chahta hu
        PrintWriter out = res.getWriter();

        out.println("<h1>Hello World</h1>");
    }
}
