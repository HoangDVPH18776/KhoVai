package com.example.khovai.Service;

import com.example.khovai.DomainModels.Category;
import com.example.khovai.DomainModels.Sub_Cate;
import com.example.khovai.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category_Service {
    @Autowired private CategoryRepository repo;

    public Category findByID(int id){
        Category ct = repo.findById(id).get();
        return ct;
    }
//    public List<Category> listAll(int page){
//        List<Category> lst =(List<Category>)repo.findAll();
////        List<Sub_Cate> lstpage5=lst.subList((page-1)*5,page*5);
//        return lst;
//    }

}
