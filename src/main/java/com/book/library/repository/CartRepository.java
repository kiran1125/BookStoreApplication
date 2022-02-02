package com.book.library.repository;

import java.util.List;

import com.book.library.model.CartData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartData,Integer> {
    
    
    @Query(value = "SELECT * FROM cart where user_Id = :id", nativeQuery = true)
    List<CartData> findAllByUserId(int id);

    
}
