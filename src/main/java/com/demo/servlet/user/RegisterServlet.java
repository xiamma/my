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
import java.util.Date;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 获取客户端传来的参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer role = Integer.valueOf(request.getParameter("role"));

        // 实例化对象
        User user = new User(username, password, null, role);

        // 注册用户
        int result = userService.register(user);

        request.setAttribute("status",500);
        request.setAttribute("data","未知错误");

        if(result == UserConstants.USER_SUCCESS) {
            request.setAttribute("status",UserConstants.USER_SUCCESS);
            request.setAttribute("data","注册成功");
//            request.getRequestDispatcher("login.jsp").forward(request, response);

        }else if(result == UserConstants.USER_RE) {
            request.setAttribute("status",UserConstants.USER_RE);
            request.setAttribute("data","用户名重复");
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);

    }



}
