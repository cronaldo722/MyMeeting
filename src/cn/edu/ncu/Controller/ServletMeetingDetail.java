package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.Service.Impl.MeetingServiceImpl;
import cn.edu.ncu.vo.Meeting;
import cn.edu.ncu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletMeetingDetail",urlPatterns = "/MeetingDetail")
public class ServletMeetingDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMeetingService meetingService=new MeetingServiceImpl();
        String mid = request.getParameter("mid");
        Meeting meeting = meetingService.getMeetingById(mid);
        List<User> users = meetingService.getMeetingUsers(mid);
        request.setAttribute("mt", meeting);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/meetingdetails.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
