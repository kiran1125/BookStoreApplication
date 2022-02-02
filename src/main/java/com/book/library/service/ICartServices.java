package com.book.library.service;

import java.util.List;

import com.book.library.dto.CartDTO;
import com.book.library.model.CartData;

public interface ICartServices {

    CartData addToCart(String token, CartDTO cartDTO);

    void deleteItemFromCart(String token, int cartId);

    CartData updateQuantity(String token, int cartId, int quantity);

    List<CartData> getAllItemsInCart(String token);

    List<CartData> getAllItemsInCart();
    
}
