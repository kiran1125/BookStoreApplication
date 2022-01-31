package com.book.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.book.library.dto.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookData {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column( name = "bookName")
    private String bookName;
    @Column  (name = "bookAuthor")
    private String bookAuthor;
    @Column (name = "bookDescription")
    private String bookDescription;
    @Column (name = "bookLogo")
    private String bookLogo;
    @Column (name = "bookPrice")
    private int bookPrice;
    @Column (name = "bookQuantity")
    private int bookQuantity;


    public BookData(BookDTO bookDTO) {
        this.bookName = bookDTO.getBookName();
        this.bookAuthor = bookDTO.getBookAuthor();
        this.bookDescription = bookDTO.getBookDescription();
        this.bookLogo = bookDTO.getBookLogo();
        this.bookPrice = bookDTO.getBookPrice();
        this.bookQuantity = bookDTO.getBookQuantity();

    }


    public void updateBookData(BookDTO bookDTO) {
        this.bookName = bookDTO.getBookName();
        this.bookAuthor = bookDTO.getBookAuthor();
        this.bookDescription = bookDTO.getBookDescription();
        this.bookLogo = bookDTO.getBookLogo();
        this.bookPrice = bookDTO.getBookPrice();
        this.bookQuantity = bookDTO.getBookQuantity();
    }
}
