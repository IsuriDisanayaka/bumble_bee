package com.icbt.bumble_bee.repo.queryFactory.impl;

import com.icbt.bumble_bee.entity.Product;
import com.icbt.bumble_bee.entity.User;
import com.icbt.bumble_bee.repo.ProductRepo;
import com.icbt.bumble_bee.repo.UserRepo;
import com.icbt.bumble_bee.repo.queryFactory.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/14/2023
 **/
@Component
public class QueryFactoryImpl implements QueryFactory {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<User> GenerateSearchQuery(String type, String input) {
        switch (type) {
            case "id":
                return userRepo.findByIdLike(Integer.parseInt(input));
            case "fullName":
                return userRepo.findByFullNameLike(input);
            case "address":
                return userRepo.findByAddress(input);
            case "contact":
                return userRepo.findByContact(input);
            case "email":
                return userRepo.findByEmail(input);
            case "nic":
                return userRepo.findByNic(input);
            case "dateOfBirth":
                return userRepo.findByDateOfBirth(input);
            case "gender":
                return userRepo.findByGender(input);
            case "budget":
                return userRepo.findByBudget(Double.parseDouble(input));


            default:
                return null;

        }

    }

    @Override
    public List<Product> GenerateSearchQueryByProduct(String type, String input) {
        switch (type) {
            case "id":
                return productRepo.findByIdLike(Integer.parseInt(input));
            case "name":
                return productRepo.findByNameLike(input);
            case "brandName":
                return productRepo.findByBrandNameLike(input);
            case "category":
                return productRepo.findByCategoryLike(input);
            case "createdDate":
                return productRepo.findByDate(input);

            default:
                return null;
        }
    }
}