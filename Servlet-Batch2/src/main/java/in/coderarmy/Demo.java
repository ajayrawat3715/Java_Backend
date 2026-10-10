package in.coderarmy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Demo extends HttpServlet {
    @Override
     protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();

        System.out.println(
                """
                <html>
                <body>
                <h1>requestURI: %s</h1>
                <h1>contextPath: %s</h1>
                <h1>servletPaht: %s</h1>
                <h1>pathInfo: %s</h1>
                </body>
                </html>
                
                   """.formatted(
                           requestURI,
                        contextPath,
                        servletPath,
                        pathInfo));
     }

}
