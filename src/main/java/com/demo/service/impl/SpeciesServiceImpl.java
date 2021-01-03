package com.demo.service.impl;

import com.demo.dao.SpeciesDao;
import com.demo.entity.Species;
import com.demo.service.SpeciesService;

import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-18 下午4:50
 */
public class SpeciesServiceImpl implements SpeciesService {

    private SpeciesDao speciesDao = new SpeciesDao();

    @Override
    public List<Species> selectAll() {

        return speciesDao.findAll();
    }

    @Override
    public int addSpecies(Species species) {
        return speciesDao.insert(species);
    }

    @Override
    public int updateSpecies(Species species) {
        return speciesDao.update(species);
    }

    @Override
    public int deletepecies(Integer id) {
        return speciesDao.delete(id);
    }
}
