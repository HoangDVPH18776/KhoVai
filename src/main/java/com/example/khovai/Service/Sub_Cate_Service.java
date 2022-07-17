package com.example.khovai.Service;

import com.example.khovai.DomainModels.Sub_Cate;
import com.example.khovai.Repository.Sub_CateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Sub_Cate_Service {

    @Autowired private Sub_CateRepository repo;

    public Page<Sub_Cate> listAll(int pageNumber){
        Pageable page = PageRequest.of(pageNumber-1,3);
//        List<Sub_Cate> lst =(List<Sub_Cate>)repo.findAll();
//        List<Sub_Cate> lstpage5=lst.subList((page-1)*5,page*5);
        return repo.findAll(page);
    }


//    public Page<Sub_Cate> listAll(Pageable pageable){
//        return (Page<Sub_Cate>) repo.findAll();
//    }
    public void saveSub_Cate (Sub_Cate sc){

        repo.save(sc);
    }
    public Sub_Cate get(int id) throws Exception{
        Optional<Sub_Cate> sc = repo.findById(id);
        if(sc.isPresent()){
            return sc.get();
        }
        throw new Exception("Không tìm thấy"+id);
    }
    public boolean checkExist ( int id) {
        return repo.existsById(id);
    }

}
