package com.book.library.service;

import java.util.List;
import java.util.Optional;

import com.book.library.Util.TokenUtil;
import com.book.library.dto.BookDTO;
import com.book.library.model.BookData;
import com.book.library.model.UserRegistrationData;
import com.book.library.repository.BookRepository;
import com.book.library.repository.UserRegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServices implements IBookServices {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private UserRegistrationRepository userRepo;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public List<BookData> showAllBooks(String token) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            return bookRepo.findAll();
        }else{
            return null;
        }
    }

    @Override
    public BookData getBookById(String token, int bookId) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            return bookRepo.getById(bookId);
        }else{
        return null;
    }
    }

    @Override
    public BookData addBook(String token,BookDTO bookDTO) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            BookData bookData = new BookData(bookDTO);
            return bookRepo.save(bookData);
        }else{
        return null;
    }
    }

    @Override
    public BookData updateBook(String token, int bookId, BookDTO bookDTO) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            BookData bookData = this.getBookById(token, bookId);
            bookData.updateBookData(bookDTO);
            return bookRepo.save(bookData);
        }else{
        return null;
    }
    }

    @Override
    public void deleteBook(String token, int bookId) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            BookData bookData = this.getBookById(token, bookId);
            bookRepo.delete(bookData);
        }
    }

    @Override
    public BookData updateBookQuantity(String token, int bookId, int bookQuantity) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            BookData bookData = this.getBookById(token, bookId);
            bookData.setBookQuantity(bookQuantity);
            return bookRepo.save(bookData);
        }else{
        return null;
    }
    }

    @Override
    public BookData updateBookPrice(String token, int bookId, int bookPrice) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            BookData bookData = this.getBookById(token, bookId);
            bookData.setBookPrice(bookPrice);
            return bookRepo.save(bookData);
        }else{
        return null;
    }
    }
    
}
