package com.book.library.service;

import java.util.List;

import javax.validation.Valid;

import com.book.library.Util.Response;
import com.book.library.dto.LoginDTO;
import com.book.library.dto.UserRegistrationDTO;
import com.book.library.model.UserRegistrationData;

public interface IUserRegistratioServices {

    List<UserRegistrationData> getUserDetails();

    Response userRegistration(UserRegistrationDTO userDTO);

    UserRegistrationData getUserDataById(int id);

    UserRegistrationData updateUserData(Integer id,UserRegistrationDTO userDTO);

    void deleteEmployeeData(Integer id);

	Response loginDetails(LoginDTO loginDTO);

    String verifyUser(String token);
    
}
