package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Myservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();


        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();


//      out.println("<h1>Welcome to the lecture of Sunday!</h1>.");

        out.println(
                """
                <html>
                <body>
                <h1>requestURI: %s</h1>
                <h1>contextPath: %s</h1>
                <h1>servletPath: %s</h1>
                <h1>pathInfo: %s</h1>
                <h2>Hello World!</h2>
                </body>
                </html>
                """.formatted(requestURI,contextPath,servletPath,pathInfo));
    }
}
