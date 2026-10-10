package in.coderarmy;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myapp")
public class MyApp extends HttpServlet {
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out =  res.getWriter();

       ServletContext ctx =  getServletContext();//Application

       ctx.setAttribute("late","15");

       String late = (String)ctx.getAttribute("late");

        out.println("<h1>Application: %s</h1>".formatted(late));

    }
}
