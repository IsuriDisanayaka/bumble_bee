package com.icbt.bumble_bee.service;

import com.icbt.bumble_bee.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/17/2023
 **/
public interface ProductService {
    String saveProduct(ProductDto dto);
    List<ProductDto> searchProduct(String type, String input);
    ArrayList<ProductDto>getProducts();
    void updateProduct (ProductDto dto);
    Boolean deleteProduct(int id);



}

