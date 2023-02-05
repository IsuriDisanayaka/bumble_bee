package com.icbt.bumble_bee.util.mapper;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
@Mapper(componentModel="spring")
public interface UserMapper {

        User toUser(UserDto userDto);
        UserDto toUserDTO(User user);
        List<UserDto> pageToUserDTO(Page<User> users);
        List<User> toUser(List<UserDto> userDtos);
    }

