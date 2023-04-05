package com.icbt.bumble_bee.service.impl;

import com.icbt.bumble_bee.entity.Admin;
import com.icbt.bumble_bee.repo.AdminRepo;
import com.icbt.bumble_bee.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 4/3/2023
 **/
@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;


    @Autowired
    ModelMapper mapper;
//
//    @Override
//    public boolean emailExists(String email) {
//        return adminRepo.findByEmail(email).isPresent();
//    }
//
//    @Override
//    public Admin createUser(Admin admin) {
//        return adminRepo.save(admin);
//    }
//
//    @Override
//    public Optional<Admin> findByEmail(String email) {
//        return adminRepo.findByEmail(email);
//    }
//
//    @Override
//    public void setVerificationToken(Admin admin, String token) {
//       admin.setVerificationToken(token);
//       adminRepo.save(admin);
//    }
//
//    @Override
//    public void setVerified(Admin admin) {
//        admin.setVerified(true);
//        userRepository.save(user);
//    }

    @Override
    public Boolean searchUser(String email, String password) {

        return adminRepo.existsAdminByEmailAndPassword(email,password);

    }
}
