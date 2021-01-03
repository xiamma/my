package com.demo.servlet.pet;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.SystemConstants;
import com.demo.entity.Pet;
import com.demo.entity.User;
import com.demo.service.PetService;
import com.demo.service.impl.PetServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "petUpdateServlet", urlPatterns = "/petUpdate")
public class PetUpdateServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");

        /**
         *  处理前端的formData数据
         *  request.getParameter() 获取不到数据
         */

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Map<String, String> param = new HashMap();
        String imgPath = null;
        boolean isImg = true;

        for (FileItem fileItem : items) {
            if (fileItem.isFormField()) {
                param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));//如果你页面编码是utf-8的
            }else {
                //获得上传文件的名称
                String filename = fileItem.getName();

                if(filename == null || "".equals(filename)) {
                    isImg = false;
                }else {
                    filename = new Date().getTime() + "_" + new Random().nextInt(1000) + filename; // 防止图片重复
                    imgPath = "assets/petImg/" + filename;

                    String basePath = getServletContext().getRealPath("assets/petImg/");  //项目根目录

                    String path = basePath + filename;
                    System.out.println("path: " + path);

                    File file = new File(path);

                    try {
                        // 保存文件
                        fileItem.write(file);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        // 获取参数
        String type = param.get("type");
        String name = param.get("name");
        Integer sid = Integer.valueOf(param.get("sid"));
        Integer isJY = Integer.valueOf(param.get("isJY"));
        String character = param.get("character");


        // 封装Pet对象
        Pet pet = new Pet();
        pet.setName(name);
        pet.setIsJY(isJY);
        pet.setCharacter(character);
        pet.setSid(sid);

        // 设置图片路径
        if(isImg) {
            pet.setImg(imgPath);
        }else {
            pet.setImg(param.get("formerImg"));
        }

        JSONObject json = new JSONObject();

        if (SystemConstants.UPDATE.equals(type)) {
            // 设置id
            Integer id = Integer.valueOf(param.get("id"));
            pet.setId(id);
            int i = petService.updatePet(pet);
            if(SystemConstants.SUCCESS == i) {
                json.put("status", 200);
                json.put("msg", "修改成功！");
            }else {
                json.put("status", 500);
                json.put("msg", "修改失败！");
            }
        }else if (SystemConstants.ADD.equals(type)) {

            // 设置爱心机构的id
            User user = (User) request.getSession().getAttribute("user");
            pet.setOid(user.getId());
            int i = petService.addPet(pet);
            if(SystemConstants.SUCCESS == i) {
                json.put("status", 200);
                json.put("msg", "添加成功！");
            }else {
                json.put("status", 500);
                json.put("msg", "添加失败！");
            }
        }

        response.getWriter().println(json.toString());

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        Pet pet = petService.selectById(id);

        request.setAttribute("pet", pet);

        System.out.println(pet.getDetail());

        request.getRequestDispatcher("petUpdate.jsp").forward(request, response);
    }
}
