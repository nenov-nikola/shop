package com.store.service;

import com.store.model.Commodity;
import com.store.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CommodityService {

    private CommodityRepository stokeRepository;

    @Autowired
    public CommodityService(CommodityRepository stokeRepository) {
        this.stokeRepository = stokeRepository;
    }

    public List<Commodity> getAll() {
        return stokeRepository.findAll();
    }

    public Commodity getCommodity(int id) {
        return stokeRepository.findOne(id);
    }

    public void deleteCommodity(int id) {
        stokeRepository.delete(id);
    }

    public Commodity addCommodity(Commodity commodity) {
        if(commodity.getId() != null && stokeRepository.exists(commodity.getId())) {
            throw new EntityExistsException("There is already existing entity with this id.");
        }

        return stokeRepository.save(commodity);
    }

    public Commodity updateCommodity(Commodity commodity) {
        if (commodity.getId() != null && !stokeRepository.exists(commodity.getId())) {
            throw new EntityNotFoundException("There is no entry with this id.");
        }

        return stokeRepository.save(commodity);
    }

}
