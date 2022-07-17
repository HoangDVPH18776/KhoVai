package com.example.khovai.Service;

import com.example.khovai.DomainModels.Product;
import com.example.khovai.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_Service {
    @Autowired
    private ProductRepository repo;

    public Page<Product> listAll(int pageNumber ){
        Pageable page = PageRequest.of(pageNumber-1,3);
        return   repo.findAll(page);
    }
    public void del(int id){
        repo.deleteById(id);
    }
    public void delBra_Pro(int id){
        repo.delBra_Pro(id);
    }
    public void save (Product product){
        repo.save(product);
    }
    public Product getByID(int id){
        return repo.findById(id).get();
    }
}
