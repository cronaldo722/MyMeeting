package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.IMeetingService;
import cn.edu.ncu.Service.Impl.MeetingServiceImpl;
import cn.edu.ncu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletManagerMeetings",urlPatterns = "/ManagerMeeting")
public class ServletManagerMeeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid=request.getParameter("mid");
        User UserLogin=(User)request.getSession().getAttribute("UserLogin");
        if(UserLogin.getRole()==3){
            IMeetingService meetingService=new MeetingServiceImpl();
            if(meetingService.UpdataMeetingById(mid)){
                request.setAttribute("upmmsg","修改成功");
                request.getRequestDispatcher("ServletViewMeeting").forward(request, response);
            }
        }
    }
}
