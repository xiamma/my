package com.demo.servlet.pet;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.SystemConstants;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PetDeleteServlet" ,urlPatterns = "/petDelete")
public class PetDeleteServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");
        Integer id = Integer.valueOf(request.getParameter("id"));

        int i = petService.deletePetByid(id);

        JSONObject json = new JSONObject();
        if(SystemConstants.SUCCESS == i) {
            json.put("status", 200);
            json.put("msg", "删除成功！");
        }else {
            json.put("status", 500);
            json.put("msg", "删除失败！");
        }

        response.getWriter().println(json.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
