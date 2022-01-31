package com.book.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookLogo;
    private Integer bookPrice;
    private Integer bookQuantity;
}
