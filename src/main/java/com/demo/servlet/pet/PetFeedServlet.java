package com.demo.servlet.pet;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.SystemConstants;
import com.demo.entity.User;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PetFeedServlet", urlPatterns = "/petFeed")
public class PetFeedServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        // 从session中获取饲主id
        User user = (User)request.getSession().getAttribute("user");
        Integer fid = user.getId();
        Integer id = Integer.valueOf(request.getParameter("id"));

        int i = petService.feedPet(fid, id);

        JSONObject json = new JSONObject();

        if(SystemConstants.SUCCESS == i) {
            json.put("status", 200);
            json.put("msg", "领养成功！");
        }else {
            json.put("status", 500);
            json.put("msg", "领养失败！");
        }

        response.getWriter().println(json.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
