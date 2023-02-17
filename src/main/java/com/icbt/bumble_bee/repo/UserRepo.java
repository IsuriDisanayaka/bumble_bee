package com.icbt.bumble_bee.repo;

import com.icbt.bumble_bee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM  User where id like ?%  ", nativeQuery = true)
    List<User> findByIdLike(@NotNull int input);


    @Query(value="SELECT * FROM User where full_name like %?% ",nativeQuery = true)
    List<User> findByFullNameLike(String input);

    @Query(value="SELECT * FROM User where address like %?% ",nativeQuery = true)
    List<User> findByAddress(String input);

    @Query(value="SELECT * FROM User where contact like ?% ",nativeQuery = true)
    List<User> findByContact(String input);

    @Query(value="SELECT * FROM User where email like %?% ",nativeQuery = true)
    List<User> findByEmail(String input);

    @Query(value="SELECT * FROM User where nic like %?% ",nativeQuery = true)
    List<User> findByNic(String input);

    @Query(value="SELECT * FROM User where date_of_birth  ",nativeQuery = true)
    List<User> findByDateOfBirth(String input);

    @Query(value="SELECT * FROM User where gender like %?%",nativeQuery = true)
    List<User> findByGender(String input);

    @Query(value = "SELECT * FROM  User where budget like ?%  ", nativeQuery = true)
    List<User> findByBudget(double parseInt);


}
