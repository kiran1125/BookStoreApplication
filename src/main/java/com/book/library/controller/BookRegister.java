package com.book.library.controller;

import java.util.List;

import com.book.library.dto.BookDTO;
import com.book.library.dto.ResponseDTO;
import com.book.library.model.BookData;
import com.book.library.service.IBookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bookregister")
public class BookRegister {

    @Autowired
    private IBookServices bookServices;

    @GetMapping("/getbooks")
    public ResponseEntity<ResponseDTO> getAllBooks(@RequestHeader(name = "token") String token ) {
        List<BookData> allBooks = bookServices.showAllBooks(token);
        ResponseDTO response = new ResponseDTO("All Books Retrieved successfully:", allBooks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getbook/{bookId}")
    public ResponseEntity<ResponseDTO> getOneBook(@RequestHeader(name = "token") String token,@PathVariable int bookId)
    {
        BookData book = bookServices.getBookById(token,bookId);
        ResponseDTO response = new ResponseDTO("Book retrieved successfully"+bookId, book);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/addbook")
    public ResponseEntity<ResponseDTO> addBook(@RequestHeader(name = "token") String token,@RequestBody BookDTO bookDTO)
    {
        BookData book = bookServices.addBook(token,bookDTO);
        ResponseDTO response = new ResponseDTO("Book added successfully", book);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookData(@RequestHeader(name = "token") String token,@PathVariable("bookId") int bookId,
                                                       @RequestBody BookDTO bookDTO) {
        BookData book = bookServices.updateBook(token,bookId, bookDTO);
        ResponseDTO response = new ResponseDTO("Updated  for" + bookId, book);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookData(@RequestHeader(name = "token") String token,@PathVariable("bookId") int bookId) {
        bookServices.deleteBook(token,bookId);
        ResponseDTO response = new ResponseDTO("Deleted  book with id :" , bookId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/updatequantity/{bookId}/{bookQuantity}")
    public ResponseEntity<ResponseDTO> updateBookQuantity(@RequestHeader(name = "token") String token,@PathVariable int bookId, @PathVariable int bookQuantity) {
        BookData updateBookQuantity = bookServices.updateBookQuantity(token,bookId, bookQuantity);
        ResponseDTO response = new ResponseDTO("Book Quantity Update is success for id " + bookId, updateBookQuantity);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/updateprice/{bookId}/{bookPrice}")
    public ResponseEntity<ResponseDTO> updateBookPrice(@RequestHeader(name = "token") String token,@PathVariable int bookId, @PathVariable int bookPrice) {
        BookData updateBookPrice = bookServices.updateBookPrice(token,bookId, bookPrice);
        ResponseDTO response = new ResponseDTO("Book Price Update is success for id " + bookId, updateBookPrice);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
