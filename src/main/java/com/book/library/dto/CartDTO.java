package com.book.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {
    
    private int userId;
    private int bookId;
    private int quantity;
}
