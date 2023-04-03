package com.icbt.bumble_bee.repo;

import com.icbt.bumble_bee.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 4/3/2023
 **/
@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

   // Optional<Admin> findByEmail(String email);
Boolean existsAdminByEmailAndPassword(String email,String password);
}
