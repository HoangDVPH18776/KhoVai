package com.example.khovai.Service;

import com.example.khovai.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Status_Service {
    @Autowired private StatusRepository repo;
    public boolean checkExist(int id){
        return repo.existsById(id);
    }
}
