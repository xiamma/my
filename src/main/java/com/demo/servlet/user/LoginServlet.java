package com.demo.servlet.user;

import com.demo.common.UserConstants;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取客户端传来的参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 实例化对象
        User user = new User(username, password);

        int status = userService.login(user, request);

        // 登录成功
        if(UserConstants.USER_LOGIN_SUCCESS == status) {
//            request.getRequestDispatcher("index").forward(request, response);
            response.sendRedirect("index");
            return;
        }else if (UserConstants.USER_NAME_NO == status) {
            request.setAttribute("message", "账号不存在！");
        }else if (UserConstants.USER_PWD_ERR == status) {
            request.setAttribute("message", "密码不正确！");
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
