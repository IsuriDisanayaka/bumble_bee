package com.icbt.bumble_bee.repo.queryFactory.impl;

import com.icbt.bumble_bee.entity.User;
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

    @Override
    public List<User> GenerateSearchQuery(String type, String input) {
        switch (type) {
            case "id" :
             return userRepo.findByIdLike(Integer.parseInt(input));
            case "full_name":
                return userRepo.findByFullNameLike(input);
            case "address":
                return userRepo.findByAddress(input);
            case "contact":
                return userRepo.findByContact(input);
            case "email":
                return userRepo.findByEmail(input);
            case "nic":
                return userRepo.findByNic(input);
            case "date_of_birth":
                return userRepo.findByDateOfBirth(input);
            case "gender":
                return userRepo.findByGender(input);
            case "budget":
                return userRepo.findByBudget(Integer.parseInt(input));


            default:
                return null;

        }

    }
}