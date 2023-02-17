package com.icbt.bumble_bee.repo.queryFactory;

import com.icbt.bumble_bee.entity.Product;
import com.icbt.bumble_bee.entity.User;

import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/14/2023
 **/

public interface QueryFactory {
    List<User> GenerateSearchQuery(String type, String input);
    List<Product>GenerateSearchQueryByProduct(String type, String input);

}
