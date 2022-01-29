package com.book.library.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegistrationDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "First name Invalid")
    @NotEmpty(message = "Name can not be NULL")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Last name Invalid")
    @NotEmpty(message = "Name can not be NULL")
    private String lastName;
    private String kyc;
    private String emailId;
    private String password;

    private Date dob;
    private Boolean verify;
}
