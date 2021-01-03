package com.demo.servlet.species;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.demo.dao.SpeciesDao;
import com.demo.entity.PageData;
import com.demo.entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SpeciesQyeryServlet", urlPatterns = "/speciesQuery")
public class SpeciesQyeryServlet extends HttpServlet {

    private SpeciesDao speciesDao = new SpeciesDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        List<Species> all = speciesDao.findAll();
//        PageData<Species> speciesPageData = new PageData<>(all);



        response.getWriter().println(JSON.toJSONString(all));
    }
}
