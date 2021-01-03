package com.demo.servlet;

import com.alibaba.fastjson.JSON;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午4:07
 */
@WebServlet(name = "IndexServlet",urlPatterns={"/index"})
public class IndexServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


        req.getRequestDispatcher("index.jsp").forward(req, response);
    }
}
