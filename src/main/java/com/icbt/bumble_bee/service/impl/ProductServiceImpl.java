package com.icbt.bumble_bee.service.impl;

import com.icbt.bumble_bee.dto.ProductDto;
import com.icbt.bumble_bee.entity.Product;
import com.icbt.bumble_bee.exception.ValidateException;
import com.icbt.bumble_bee.repo.ProductRepo;
import com.icbt.bumble_bee.repo.queryFactory.QueryFactory;
import com.icbt.bumble_bee.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/17/2023
 **/
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;


    @Autowired
    ModelMapper mapper;
    @Autowired
    QueryFactory queryFactory;


    @Override
    public String saveProduct(ProductDto dto) {
       if (productRepo.existsById(dto.getId())){
           throw new ValidateException("Product Already Exist");
       }
     Product product = productRepo.save(mapper.map(dto, Product.class ));

        return product.getName();
    }

    @Override
    public List<ProductDto> searchProduct(String type, String input) {
        List<Product> search=queryFactory.GenerateSearchQueryByProduct(type,input);
        return mapper.map(search, new TypeToken<ArrayList<ProductDto>>(){}.getType());
    }


    @Override
    public ArrayList<ProductDto> getProducts() {

        List<Product>all= productRepo.findAll();
        return mapper.map(all , new TypeToken<ArrayList<ProductDto>>(){}.getType());
    }

    @Override
    public void updateProduct(ProductDto dto) {
        if (productRepo.existsById(dto.getId())) {
           productRepo.save(mapper.map(dto, Product.class));

        }
    }
    @Override
    public Boolean deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new ValidateException("No User for Delete..!");
        }
       productRepo.deleteById(id);
        return true;
    }
}
