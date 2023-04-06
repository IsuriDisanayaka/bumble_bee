package com.icbt.bumble_bee.repo;


import com.icbt.bumble_bee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/17/2023
 **/
@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM  Product where id like ?%  ", nativeQuery = true)
    List<Product> findByIdLike(@NotNull int input);

    @Query(value="SELECT * FROM Product where name like %?% ",nativeQuery = true)
    List<Product> findByNameLike(String input);

    @Query(value="SELECT * FROM Product where brand_name like %?% ",nativeQuery = true)
    List<Product> findByBrandNameLike(String input);

    @Query(value="SELECT * FROM Product where category like %?% ",nativeQuery = true)
    List<Product> findByCategoryLike(String input);

    @Query(value="SELECT * FROM Product where created_date  ",nativeQuery = true)
    List<Product> findByDate(String input);

    @Query(value = "SELECT COUNT(*) FROM Product ")
    int getTotalProducts();


}
