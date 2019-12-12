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
import java.util.List;

@WebServlet(name = "ServletShowAllUsers",urlPatterns = "/ShowAllUsers")
public class ServletShowAllUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User UserLogin=(User)request.getSession().getAttribute("UserLogin");
        if(UserLogin.getRole()==3){
            UserService userService=new UserServiceImpl();
            List<User> Musers=userService.ShowAllUsers();
            request.setAttribute("Musers",Musers);
            request.getRequestDispatcher("/ManagerUsers.jsp").forward(request, response);
        }
    }
}
