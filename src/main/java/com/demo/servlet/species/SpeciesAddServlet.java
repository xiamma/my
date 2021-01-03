package com.demo.servlet.species;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.SystemConstants;
import com.demo.entity.Species;
import com.demo.service.SpeciesService;
import com.demo.service.impl.SpeciesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SpeciesAddServlet", urlPatterns = "/speciesAdd")
public class SpeciesAddServlet extends HttpServlet {

    private SpeciesService speciesService = new SpeciesServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");
        String name = request.getParameter("name");


        Species species = new Species(name);
        int i = speciesService.addSpecies(species);

        JSONObject json = new JSONObject();
        if(SystemConstants.SUCCESS == i) {
            json.put("status", 200);
            json.put("msg", "添加成功！");
        }else {
            json.put("status", 500);
            json.put("msg", "添加失败！");
        }

        response.getWriter().println(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
