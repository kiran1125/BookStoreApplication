package com.book.library.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.book.library.dto.UserRegistrationDTO;

import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "userregistration")
@Data
@Setter
public class UserRegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column
    private String kyc;
    @Column(name = "emailId")
    private String emailId;
    @Column
    private String password;

    @Column
    private Date dob;
    @Column(name = "registerDate")
    private LocalDate registerDate;
    @Column(name = "updatedDate")

    private LocalDate updatedDate;

    private Boolean verify = false;

    public void createUser(UserRegistrationDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.kyc = userDTO.getKyc();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.registerDate = LocalDate.now();

    }
    
    
    public void updateUserData(UserRegistrationDTO userDTO) {

        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.kyc = userDTO.getKyc();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.updatedDate = LocalDate.now();
    }
}
