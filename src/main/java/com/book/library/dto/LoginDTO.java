package com.book.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
    
    private String emailId;
    private String password; 
}
