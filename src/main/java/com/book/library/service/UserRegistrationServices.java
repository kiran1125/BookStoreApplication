package com.book.library.service;

import java.util.List;
import java.util.Optional;


import com.book.library.Util.Response;
import com.book.library.Util.TokenUtil;
import com.book.library.dto.UserRegistrationDTO;
import com.book.library.exceptions.UserNotFoundException;
import com.book.library.exceptions.UserRegisrationException;
import com.book.library.model.UserRegistrationData;
import com.book.library.repository.UserRegistrationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServices implements IUserRegistratioServices {

    @Autowired
    private UserRegistrationRepository userRepo;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public List<UserRegistrationData> getUserDetails() {
        return userRepo.findAll();
    }

    @Override
    public Response userRegistration(UserRegistrationDTO userDTO) {
        Optional<UserRegistrationData> isPresent=userRepo.findByEmailId(userDTO.getEmailId());
		if(isPresent.isPresent()) {
			throw new UserRegisrationException(400, "Email Already exists");
		}else {
			UserRegistrationData userData=new UserRegistrationData();
            userData.createUser(userDTO);
			String token=tokenUtil.createToken(userData.getUserId());
            userRepo.save(userData);
			return new Response(200, "Employee Succefully Added", token);
		}
       
    }

    @Override
    public UserRegistrationData getUserDataById(int id) {
        return userRepo.findById(id).orElseThrow(() 
                    -> new UserNotFoundException("User Not Found"));
    }

    @Override
    public UserRegistrationData updateUserData(Integer id,UserRegistrationDTO userDTO) {
        UserRegistrationData userData = this.getUserDataById(id);
        userData.updateUserData(userDTO);
        return userRepo.save(userData);
    }

    @Override
    public void deleteEmployeeData(Integer id) {
        UserRegistrationData userData = this.getUserDataById(id);
        userRepo.delete(userData);
        
    }

    

}
