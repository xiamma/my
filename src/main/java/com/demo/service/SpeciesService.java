package com.demo.service;

import com.demo.entity.Species;

import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-18 下午4:46
 */
public interface SpeciesService {

    /**
     * 查询所有种类数据
     * @return
     */
    List<Species> selectAll();

    /**
     * 添加种类
     * @param species
     * @return
     */
    int addSpecies(Species species);

    /**
     * 修改种类
     * @param species
     * @return
     */
    int updateSpecies(Species species);

    /**
     * 删除种类
     * @param id
     * @return
     */
    int deletepecies(Integer id);
}
