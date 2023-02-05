package com.icbt.bumble_bee.repo;

import com.icbt.bumble_bee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public interface UserRepo extends JpaRepository<User,Integer> {


}
