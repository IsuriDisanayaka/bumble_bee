package com.icbt.bumble_bee.service.impl;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.entity.User;
import com.icbt.bumble_bee.exception.ValidateException;
import com.icbt.bumble_bee.repo.UserRepo;
import com.icbt.bumble_bee.repo.queryFactory.QueryFactory;
import com.icbt.bumble_bee.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/4/2023
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    QueryFactory queryFactory;

    @Override
    public UserDto saveUser(UserDto dto) {

            if (userRepo.existsById(dto.getId())) {
                throw new ValidateException("User Already Exist");
            }
         // dto.setDeleted(false);

         User user = userRepo.save(mapper.map(dto, User.class ));

         return mapper.map(user,UserDto.class);


    }

    @Override
    public ArrayList<UserDto> getGetAllUsers() {
        List<User>all= userRepo.findAll();
        return mapper.map(all , new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

    @Override
    public List<UserDto> searchUser(String type, String input) {
        List<User>search=queryFactory.GenerateSearchQuery(type,input);
        return mapper.map(search, new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

}
