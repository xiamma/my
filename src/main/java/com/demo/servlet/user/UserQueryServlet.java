package com.demo.servlet.user;

import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserQueryServlet", urlPatterns = "/userQuery")
public class UserQueryServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");


        // 获取参数
        Integer offset = Integer.valueOf(request.getParameter("offset"));
        Integer limit = Integer.valueOf(request.getParameter("limit"));
        String search = request.getParameter("search");


        Page page = new Page(offset, limit);


        PageData<User> userPageData = userService.selectByLimit(search, page);


        response.getWriter().println(userPageData.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
