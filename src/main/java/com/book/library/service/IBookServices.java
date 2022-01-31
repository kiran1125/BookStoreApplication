package com.book.library.service;

import java.util.List;

import com.book.library.dto.BookDTO;
import com.book.library.model.BookData;

public interface IBookServices {

    List<BookData> showAllBooks(String token);

    BookData getBookById(String token, int bookId);

    BookData addBook(String token, BookDTO bookDTO);

    BookData updateBook(String token, int bookId, BookDTO bookDTO);

    void deleteBook(String token, int bookId);

    BookData updateBookQuantity(String token, int bookId, int bookQuantity);

    BookData updateBookPrice(String token, int bookId, int bookPrice);
    
}
