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

@WebServlet(name = "ServletAttendMeeting",urlPatterns = "/AttendMeeting")
public class ServletAttendMeeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid=request.getParameter("mid");
        User user =(User)request.getSession().getAttribute("UserLogin");
        IMeetingService meetingService=new MeetingServiceImpl();
        meetingService.AttendMeeingById(mid,user.getUsername());
        request.getRequestDispatcher("ShowMyMeetings").forward(request, response);


    }
}
