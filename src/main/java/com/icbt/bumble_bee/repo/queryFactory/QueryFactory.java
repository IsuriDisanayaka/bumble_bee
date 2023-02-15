package com.icbt.bumble_bee.repo.queryFactory;

import com.icbt.bumble_bee.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/14/2023
 **/

public interface QueryFactory {
    List<User> GenerateSearchQuery(String type, String input);

}
