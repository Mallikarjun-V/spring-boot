package com.learn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.dto.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT book FROM Book book WHERE book.name=(:name)")
    List<Book> findByName(@Param("name") String name);
}
