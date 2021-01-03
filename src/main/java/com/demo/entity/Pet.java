package com.demo.entity;

import java.util.Date;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午2:55
 */
public class Pet {

    private Integer id;
    private String name;
    private String img;
    private Integer isJY;  // 是否绝育 1、是；2否
    private String character;
    private String createTime;



    /**
     * 所属饲主id
     */
    private Integer fid;

    /**
     * 所属机构id
     */
    private Integer oid;

    /**
     * 宠物种类id
     */
    private Integer sid;

    private String feeder;

    private String organization;

    private String species;

    private String detail; // 详情内容


    public Pet() {
    }


    public Pet(Integer id, String name, String img, Integer isJY, String character, String createTime, Integer fid, Integer oid, Integer sid, String feeder, String organization, String species, String detail) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.isJY = isJY;
        this.character = character;
        this.createTime = createTime;
        this.fid = fid;
        this.oid = oid;
        this.sid = sid;
        this.feeder = feeder;
        this.organization = organization;
        this.species = species;
        this.detail = detail;
    }

    public Pet(Integer id, String name, String img, Integer isJY, String character, String createTime, Integer fid, Integer oid, Integer sid, String feeder, String organization, String species) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.isJY = isJY;
        this.character = character;
        this.createTime = createTime;
        this.fid = fid;
        this.oid = oid;
        this.sid = sid;
        this.feeder = feeder;
        this.organization = organization;
        this.species = species;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIsJY() {
        return isJY;
    }

    public void setIsJY(Integer isJY) {
        this.isJY = isJY;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFeeder() {
        return feeder;
    }

    public void setFeeder(String feeder) {
        this.feeder = feeder;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", isJY=" + isJY +
                ", character='" + character + '\'' +
                ", createTime='" + createTime + '\'' +
                ", fid=" + fid +
                ", oid=" + oid +
                ", sid=" + sid +
                ", feeder='" + feeder + '\'' +
                ", organization='" + organization + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
