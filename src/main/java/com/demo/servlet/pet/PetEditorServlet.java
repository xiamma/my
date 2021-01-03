package com.demo.servlet.pet;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.SystemConstants;
import com.demo.entity.Pet;
import com.demo.entity.User;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PetEditorServlet", urlPatterns = "/petEditor")
public class PetEditorServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String detail = request.getParameter("detail");

        int i = petService.updatePet(detail, id);

        JSONObject json = new JSONObject();

        if(SystemConstants.SUCCESS == i) {
            json.put("status", 200);
            json.put("msg", "提交成功！");
        }else {
            json.put("status", 500);
            json.put("msg", "提交失败！");
        }

        response.getWriter().println(json.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Pet pet = petService.selectById(id);

        request.setAttribute("pet", pet);
        request.getRequestDispatcher("petEditor.jsp").forward(request, response);

    }
}
