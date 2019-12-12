package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.Service.Impl.MeetingServiceImpl;
import cn.edu.ncu.vo.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletViewMeeting",urlPatterns = "/ServletViewMeeting")
public class ServletViewMeeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMeetingService MeetingService=new MeetingServiceImpl();
        List<Meeting> Meetings = MeetingService.getAllMeeting();
        request.setAttribute("Meetings", Meetings);
        request.getRequestDispatcher("/searchmeetings.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
