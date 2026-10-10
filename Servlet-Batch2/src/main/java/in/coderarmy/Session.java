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

@WebServlet("/session")
public class Session extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        HttpSession session = req.getSession();

        session.setAttribute("Id", "188");

        ServletContext ctx = getServletContext();

        String late = (String) ctx.getAttribute("late");
        String id = (String) session.getAttribute("Id");

        PrintWriter out = res.getWriter();

        out.println("<h1>late: %s</h1>".formatted(late));
        out.println("<h1>id: %s</h1>".formatted(id));
    }
}
