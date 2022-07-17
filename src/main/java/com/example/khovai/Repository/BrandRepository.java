package com.example.khovai.Repository;

import com.example.khovai.DomainModels.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Integer> {
}
