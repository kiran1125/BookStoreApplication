package com.book.library.controller;

import java.util.List;

import javax.validation.Valid;

import com.book.library.Util.Response;
import com.book.library.Util.TokenUtil;
import com.book.library.dto.LoginDTO;
import com.book.library.dto.ResponseDTO;
import com.book.library.dto.UserRegistrationDTO;
import com.book.library.model.UserRegistrationData;
import com.book.library.service.IUserRegistratioServices;
import com.book.library.service.UserRegistrationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userregistration")
public class UserRegistrationController {

    @Autowired
    private IUserRegistratioServices userRegistratioServices;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/read")
    public ResponseEntity<ResponseDTO> getUserData() {
        List<UserRegistrationData> usersList = userRegistratioServices.getUserDetails();
        ResponseDTO response = new ResponseDTO("Get call success", usersList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addUserRegistrationData(@Valid @RequestBody UserRegistrationDTO userDTO) {
        Response response = userRegistratioServices.userRegistration(userDTO);
        return new ResponseEntity<Response>(response,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getByUserId(@PathVariable int id){
        UserRegistrationData userData = userRegistratioServices.getUserDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get call for id Successful", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updatingUserData(@PathVariable("id") Integer id, @Valid @RequestBody UserRegistrationDTO userDTO){
		UserRegistrationData userData = userRegistratioServices.updateUserData(id,userDTO);
		ResponseDTO responseDTO = new ResponseDTO("update user data is Successful", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayRollById(@PathVariable Integer id){
		userRegistratioServices.deleteEmployeeData(id);
		ResponseDTO responseDTO = new ResponseDTO("delete data is Successful of id :", id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

    @PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO){
		Response response=userRegistratioServices.loginDetails(loginDTO);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}

    @PostMapping("/user/verify/{token}")
    public Boolean login(@PathVariable String token){
        Boolean verified = userRegistratioServices.verifyUser(token);
        return verified;
    }
    
}
