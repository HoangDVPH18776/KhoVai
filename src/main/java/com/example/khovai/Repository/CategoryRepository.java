package com.example.khovai.Repository;

import com.example.khovai.DomainModels.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
    @Override
    Optional<Category> findById(Integer integer);

    @Override
    Iterable<Category> findAll();
}
