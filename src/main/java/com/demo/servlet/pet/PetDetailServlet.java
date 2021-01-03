package com.demo.servlet.pet;

import com.demo.entity.Pet;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PetDetailServlet", urlPatterns = "/petDetail")
public class PetDetailServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Pet pet = petService.selectById(id);

        request.setAttribute("pet", pet);

        request.getRequestDispatcher("petDetail.jsp").forward(request, response);
    }
}
