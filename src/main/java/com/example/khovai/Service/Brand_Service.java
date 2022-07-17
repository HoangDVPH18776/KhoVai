package com.example.khovai.Service;

import com.example.khovai.DomainModels.Brand;
import com.example.khovai.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Brand_Service {

    @Autowired private BrandRepository repo;
    public boolean checkExist (int id){
        return repo.existsById(id);
    }
    public Brand getByID(int id){
        return repo.findById(id).get();
    }
}
