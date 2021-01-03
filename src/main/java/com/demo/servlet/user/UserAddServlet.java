package com.demo.servlet.user;

import com.alibaba.fastjson.JSONObject;
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

@WebServlet(name = "UserAddServlet", urlPatterns = "/userAdd")
public class UserAddServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");

        // 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer role = Integer.valueOf(request.getParameter("role"));


        // 实例化对象
        User user = new User(username, password, null, role);

        int register = userService.register(user);
        // 封装返回格式
        JSONObject json = new JSONObject();
        json.put("status", 500);



        if(register == UserConstants.USER_SUCCESS) {
            json.put("status", 200);
            json.put("msg", "添加成功");

        }else if(register == UserConstants.USER_RE) {
            json.put("msg", "用户名重复");
        }else {
            json.put("msg", "添加失败");
        }


        response.getWriter().println(json.toString());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
