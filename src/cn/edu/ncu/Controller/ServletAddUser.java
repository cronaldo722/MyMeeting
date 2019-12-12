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

@WebServlet(name = "ServletAddUser",urlPatterns = "/AddUser")
public class ServletAddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setName(request.getParameter("name"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setPhone((Integer.parseInt( request.getParameter("phone"))));
        UserService userService=new UserServiceImpl();
        if(userService.addUser(user)) {
            request.setAttribute("msg", "[注册成功请登录]");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "此用户名已存在，请更换用户名注册");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
