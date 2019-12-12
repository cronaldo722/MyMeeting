package cn.edu.ncu.Controller;

import cn.edu.ncu.Service.Impl.UserServiceImpl;
import cn.edu.ncu.Service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin",urlPatterns = "/Login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserService userService=new UserServiceImpl();
        int login = userService.login(name, password);
        if (login==0){
            request.setAttribute("error", "用户名或者密码输入错误，请重新登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else if(login == 1||login==2){
            request.getSession().setAttribute("UserLogin",userService.getUser(name,password));
            response.sendRedirect(request.getContextPath() + "/Manager.jsp");
        }

         /*
         if (login == 0) {
            request.setAttribute("error", "用户待审批，请稍候");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == 1) {
            request.getSession().setAttribute("loginUser", UserService.getLoginUser());
            response.sendRedirect(request.getContextPath() + "/notifications");
        } else if (login == 2) {
            request.setAttribute("error", "用户审批未通过，请重新注册");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == 3) {
            request.setAttribute("error", "用户名或者密码输入错误，请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == -1) {
            request.setAttribute("error", "账号已关闭，登陆失败，请联系管理员");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

          */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
