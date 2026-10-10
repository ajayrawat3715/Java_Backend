package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Monday extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req,
                          HttpServletResponse res)
        throws ServletException , IOException{
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<h1>Hello Today is monday");
    }
}
