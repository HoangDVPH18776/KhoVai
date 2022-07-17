package com.example.khovai.Repository;

import com.example.khovai.DomainModels.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    @Query(value="DELETE FROM product_brands a WHERE a.product_id = :proID",nativeQuery = true)
    @Modifying
    public void delBra_Pro(int proID);
}
