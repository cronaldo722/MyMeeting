package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.Impl.UserServiceImpl;
import cn.edu.ncu.Service.UserService;
import cn.edu.ncu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletManagerUsers",urlPatterns = "/ManagerUsers")
public class ServletManagerUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User Loginuser= (User)request.getSession().getAttribute("UserLogin");
        if(Loginuser.getRole()==3){
            String username=request.getParameter("username");
            int role=Integer.parseInt(request.getParameter("role"));
            UserService userService=new UserServiceImpl();
            userService.UpdataUserByUsername(username,role);
            request.setAttribute("meessge","修改成功");
            request.getRequestDispatcher("ShowAllUsers").forward(request, response);
        }
    }
}
