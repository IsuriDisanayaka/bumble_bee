package com.icbt.bumble_bee.service.impl;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.entity.User;
import com.icbt.bumble_bee.exception.ValidateException;
import com.icbt.bumble_bee.repo.UserRepo;
import com.icbt.bumble_bee.repo.queryFactory.QueryFactory;
import com.icbt.bumble_bee.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public UserDto saveUser(UserDto dto,String siteURL) throws MessagingException, UnsupportedEncodingException {

            if (userRepo.existsById(dto.getId())) {
                throw new ValidateException("User Already Exist");

            }
        dto.setVerificationCode(RandomString.make(64));
         // dto.setDeleted(false);

         User user = userRepo.save(mapper.map(dto, User.class ));
         if(user!=null){
             sendVerificationEmail(user, siteURL);
         }

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




    @Override
    public void sendVerificationEmail(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String toAddress = user.getEmail();
        String fromAddress = "isuriumeshika1@gmail.com";
        String senderName = "Isuri Disanayka";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Happy Shopping,<br>"
               ;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getFullName());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }


    @Override
    public boolean verify(String verificationCode) {
        User user = userRepo.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepo.save(user);

            return true;
        }

    }
}
