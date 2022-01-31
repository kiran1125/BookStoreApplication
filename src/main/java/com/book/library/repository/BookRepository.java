package com.book.library.repository;

import com.book.library.model.BookData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookData,Integer>  {
    
}
