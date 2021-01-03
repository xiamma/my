package com.demo.service.impl;

import com.demo.dao.PetDao;
import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.Pet;
import com.demo.entity.User;
import com.demo.service.PetService;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-16 下午7:17
 */
public class PetServiceImpl implements PetService {

    private PetDao petDao = new PetDao();



    @Override
    public PageData<Pet> selectByLimit(Map<String, Object> map, Page page) {


        String selectSql1 = "SELECT p.*, u1.username feeder, u2.username organization, s.`name` species from pet  p\n" +
                "LEFT JOIN \n" +
                "`user` u1\n" +
                "ON p.fid =  u1.id\n" +
                "LEFT JOIN\n" +
                "`user` u2\n" +
                "ON p.oid = u2.id\n" +
                "LEFT JOIN\n" +
                "species s\n" +
                "ON p.sid = s.id ";

        String selectSql2 = "SELECT count(*) from pet  p\n" +
                "LEFT JOIN \n" +
                "`user` u1\n" +
                "ON p.fid =  u1.id\n" +
                "LEFT JOIN\n" +
                "`user` u2\n" +
                "ON p.oid = u2.id\n" +
                "LEFT JOIN\n" +
                "species s\n" +
                "ON p.sid = s.id ";

        String orderSql = " order by p.createTime";
        String whereSql = " where 1 = 1 ";

        // 动态拼接SQL

        // 我的宠物
        if(map.get("fid") != null && !"".equals(map.get("fid"))) {
            whereSql += " and p.`fid` = "+ map.get("fid") +" ";
        }

        // 宠物名
        if(map.get("name") != null && !"".equals(map.get("name"))) {
            whereSql += " and p.`name` LIKE'%"+ map.get("name") + "%' ";
        }

        // 种类
        if(map.get("sid") != null && !"".equals(map.get("sid"))) {
            whereSql += " and p.`sid` = "+ map.get("sid") +"";
        }

        // 是否绝育
        if(map.get("isJY") != null && !"".equals(map.get("isJY"))) {
            whereSql += " and p.`isJY` = "+ map.get("isJY") +"";
        }

        // 是否领养
        if(map.get("isf") != null && !"".equals(map.get("isf"))) {
            if(map.get("isf").equals("1")) {
                whereSql += " and p.`fid` is not null";
            }else {
                whereSql += " and p.`fid` is null";
            }

        }


        String limitSql = selectSql1 + whereSql + orderSql +" limit ?, ?";

        String countSql = selectSql2 + whereSql ;   //查询满足条件的记录数


        // 分页查询
        List<Pet> pets = petDao.limitAll(page.getOffset(), page.getLimit(), limitSql);

        // 查询记录数
        int counts = petDao.counts(countSql);

        return new PageData<>(pets, counts);

    }


    @Override
    public Pet selectById(Integer id) {

        return petDao.queryById(id);
    }

    @Override
    public int addPet(Pet pet) {


        return petDao.insert(pet);
    }

    @Override
    public int updatePet(Pet pet) {
        return petDao.updateById(pet);
    }

    @Override
    public int feedPet(Integer fid, Integer id) {
        return petDao.updateById(fid, id);
    }

    @Override
    public int updatePet(String detail, Integer id) {
        return petDao.updateById(detail, id);
    }

    @Override
    public int deletePetByid(Integer id) {

        return  petDao.deleteById(id);
    }
}
