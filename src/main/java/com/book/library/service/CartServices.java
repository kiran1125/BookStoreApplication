package com.book.library.service;

import java.util.List;
import java.util.Optional;

import com.book.library.Util.TokenUtil;
import com.book.library.dto.CartDTO;
import com.book.library.model.BookData;
import com.book.library.model.CartData;
import com.book.library.model.UserRegistrationData;
import com.book.library.repository.CartRepository;
import com.book.library.repository.UserRegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices implements ICartServices {

    @Autowired
    private CartRepository cartrepo;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserRegistrationRepository userRepo;

    @Autowired
    private BookServices bookServices;

    @Override
    public CartData addToCart(String token, CartDTO cartDTO) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> user = userRepo.findById(id);
        if(user.isPresent()){
            BookData book = bookServices.getBookById(token, cartDTO.getBookId());

            CartData cartData = new CartData(user.get(), book, cartDTO.getQuantity());
            return cartrepo.save(cartData);
        }
        else{
        return null;
        }
    }

    @Override
    public void deleteItemFromCart(String token, int cartId) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> user = userRepo.findById(id);
        if(user.isPresent()){
            userRepo.deleteById(cartId);
        }       
    }

    @Override
    public CartData updateQuantity(String token, int cartId, int quantity) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> user = userRepo.findById(id);
        if(user.isPresent()){
            CartData cartData = cartrepo.getById(cartId);
            cartData.setQuantity(quantity);
            return cartrepo.save(cartData);
        }
        else{
        return null;
        }
    }

    @Override
    public List<CartData> getAllItemsInCart(String token) {
        int id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> user = userRepo.findById(id);
        if(user.isPresent()){
            return cartrepo.findAllByUserId(id);
        }
        return null;
    }

    @Override
    public List<CartData> getAllItemsInCart() {
        return cartrepo.findAll();
    }

    
}
