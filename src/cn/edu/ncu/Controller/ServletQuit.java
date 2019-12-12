package cn.edu.ncu.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletQuit",urlPatterns = "/SevletQuit")
public class ServletQuit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // go to login page
//        System.out.println("logout");
//        System.out.println(session.getServletContext().getAttribute("count"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        session.invalidate();
    }
}
