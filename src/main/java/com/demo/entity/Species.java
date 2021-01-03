package com.demo.entity;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午3:07
 */
public class Species {

    private Integer id;
    private String name;


    public Species(String name) {

        this.name = name;
    }

    public Species(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
