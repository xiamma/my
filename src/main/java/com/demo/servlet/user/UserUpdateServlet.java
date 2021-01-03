package com.demo.servlet.user;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.UserConstants;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", urlPatterns = "/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        // 获取参数
        Integer id = Integer.valueOf(request.getParameter("id"));
        String newPwd = request.getParameter("newPwd");


        // 封装返回格式
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("msg", "修改成功");

        int i = userService.updatePwdById(newPwd, id);


        if(UserConstants.USER_UPDATE_SUCCESS != i) {
            json.put("status", 500);
            json.put("msg", "修改失败");
        }

        response.getWriter().println(json.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
