package com.book.library.controller;

import java.util.List;

import com.book.library.dto.CartDTO;
import com.book.library.dto.ResponseDTO;
import com.book.library.model.CartData;
import com.book.library.service.ICartServices;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartServices cartService;
    
    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addToCart(@RequestHeader(name = "token") String token, @RequestBody CartDTO cartDTO) {
        CartData add = cartService.addToCart(token, cartDTO);
        ResponseDTO response = new ResponseDTO("Product Added To Cart ", add);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{cartId}")
    ResponseEntity<ResponseDTO> removeFromCart(@PathVariable("cartId") int cartId,@RequestHeader(name = "token") String token) {
        cartService.deleteItemFromCart(token,cartId);
        ResponseDTO response = new ResponseDTO("Removed item From Cart for id " , cartId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{cartId}/{quantity}")
    ResponseEntity<ResponseDTO> updateCart(@RequestHeader(name = "token") String token, @PathVariable("cartId") int cartId,@PathVariable("quantity") int quantity) {
        CartData cart = cartService.updateQuantity(token, cartId, quantity);
        ResponseDTO response = new ResponseDTO("Update item Quantity in the Cart ", cart);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<ResponseDTO> getAllCartItemsUser(@RequestHeader(name = "token") String token) {
        List<CartData> cartDatas = cartService.getAllItemsInCart(token);
        ResponseDTO response = new ResponseDTO("All Items in Cart for user ", cartDatas);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/getall")
    ResponseEntity<ResponseDTO> getAllCartItems() {
        List<CartData> cartDatas = cartService.getAllItemsInCart();
        ResponseDTO response = new ResponseDTO("All Items in Cart ", cartDatas);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


}
