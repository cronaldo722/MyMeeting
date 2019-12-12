package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.Impl.UserServiceImpl;
import cn.edu.ncu.Service.UserService;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletShowMyMeetings",urlPatterns = "/ShowMyMeetings")
public class ServletShowMyMeetings extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("UserLogin");
        UserService userService=new UserServiceImpl();
        List<Meeting> MyMeetings=new ArrayList<>();
        MyMeetings=userService.showMyMeetingsByUser(user.getUsername());
        System.out.println(MyMeetings);
        request.setAttribute("mymts",MyMeetings);
        request.getRequestDispatcher("/mymeetings.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
