package com.demo.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 封装前端分页需要的json格式
 * @Author leslee
 * @Date 2020-12-12 下午10:27
 */
public class PageData<T> extends JSONObject {

    public PageData(List<T> rows) {
        this.put("rows", rows);
        this.put("total", rows.size());

    }


    public PageData(List<T> rows, int total) {
        this.put("rows", rows);
        this.put("total", total);

    }


}
