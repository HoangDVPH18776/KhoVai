package com.example.khovai.Repository;

import com.example.khovai.DomainModels.Sub_Cate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sub_CateRepository extends PagingAndSortingRepository<Sub_Cate,Integer> {
}
