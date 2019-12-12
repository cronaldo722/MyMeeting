package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.Service.Impl.MeetingServiceImpl;
import cn.edu.ncu.vo.User;
import cn.edu.ncu.vo.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

@WebServlet(urlPatterns = "/ServletAddMeeting",name = "ServletAddMeeting")
public class ServletAddMeeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checks[]=request.getParameterValues("checks");
        String idmeeting= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String namemeeting = request.getParameter("meetingname");
        String placemeeting=request.getParameter("placemeeting");
        String roomid = request.getParameter("roomid");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        int pnums = Integer.parseInt(request.getParameter("pnums"));
        String description = request.getParameter("description");
        Meeting meeting = new Meeting(
                idmeeting,
                namemeeting,
                placemeeting,
                Integer.parseInt(roomid),
                Timestamp.valueOf(starttime),
                Timestamp.valueOf(endtime),
                pnums,
                description
        );
        IMeetingService meetingService=new MeetingServiceImpl();
        meetingService.addMeeting(meeting);
        response.sendRedirect(request.getContextPath() + "ServletViewMeeting");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
