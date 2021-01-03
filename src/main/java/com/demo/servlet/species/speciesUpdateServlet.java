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

@WebServlet(name = "speciesUpdateServlet", urlPatterns = "/speciesUpdate")
public class speciesUpdateServlet extends HttpServlet {
    private SpeciesService speciesService = new SpeciesServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");

        Species species = new Species(id, name);


        int i = speciesService.updateSpecies(species);

        JSONObject json = new JSONObject();
        if(SystemConstants.SUCCESS == i) {
            json.put("status", 200);
            json.put("msg", "修改成功！");
        }else {
            json.put("status", 500);
            json.put("msg", "修改失败！");
        }

        response.getWriter().println(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
