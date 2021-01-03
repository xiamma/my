package com.demo.service;

import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.Pet;

import java.util.Map;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-16 下午7:17
 */
public interface PetService {



    /**
     * 条件查询宠物并分页
     */
    PageData<Pet> selectByLimit(Map<String, Object> map, Page page);


    /**
     * 根据id查询宠物信息
     */
    Pet selectById(Integer id);

    /**
     * 新增宠物
     */
    int addPet(Pet pet);

    /**
     * 修改宠物
     * @param pet
     */

    int updatePet(Pet pet);


    /**
     * 领养
     * @param fid
     * @param id
     * @return
     */
    int feedPet(Integer fid, Integer id);

    /**
     * 宠物报道
     * @param detail
     * @param id
     * @return
     */
    int updatePet(String detail, Integer id);

    /**
     * 根据id删除
     */
    int deletePetByid(Integer id);
}
