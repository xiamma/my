package com.demo.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "UploadImgServlet", urlPatterns = "/uploadImg")
public class UploadImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=utf-8");


        /**
         * 接受文件
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

        String imgPath = null;

        for (FileItem fileItem : items) {
            if (!fileItem.isFormField()) {
                //获得上传文件的名称
                String filename = fileItem.getName();
                filename = new Date().getTime() + "_" + new Random().nextInt(1000) + filename; // 防止图片重复

                String basePath = getServletContext().getRealPath("assets/editorImg/");  //项目根目录

                String path = basePath + filename;
                System.out.println("path: " + path);
                File file = new File(path);
                imgPath = "assets/editorImg/" + filename;
                try {
                    // 保存文件
                    fileItem.write(file);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


        /**
         * 返回指定格式的json数据
         *
         * {
         *     // errno 即错误代码，0 表示没有错误。
         *     //       如果有错误，errno != 0，可通过下文中的监听函数 fail 拿到该错误码进行自定义处理
         *     "errno": 0,
         *
         *     // data 是一个数组，返回图片的线上地址
         *     "data": [
         *         "图片1地址",
         *         "图片2地址",
         *         "……"
         *     ]
         * }
         */



        JSONObject json = new JSONObject();
        json.put("errno", "0");
        JSONArray array = new JSONArray();
        array.add(imgPath);
        json.put("data", array);

        response.getWriter().println(json.toString());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
