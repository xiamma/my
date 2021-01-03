package com.demo.servlet.pet;

import com.demo.dao.PetDao;
import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.Pet;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PetQueryServlet", urlPatterns = "/petQuery")
public class PetQueryServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        // 获取参数
        Integer offset = Integer.valueOf(request.getParameter("offset"));
        Integer limit = Integer.valueOf(request.getParameter("limit"));
        String search = request.getParameter("search");

        // 封装查询参数到map中
        Map<String, Object> map = new HashMap<>();
        map.put("name", request.getParameter("name"));
        map.put("sid", request.getParameter("sid"));
        map.put("isJY", request.getParameter("isJY"));
        map.put("isf", request.getParameter("isf"));
        map.put("fid", request.getParameter("fid"));

        Page page = new Page(offset, limit);

        PageData<Pet> petPageData = petService.selectByLimit(map, page);

        response.getWriter().println(petPageData.toString());

    }
}
