package com.learn.dto;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    private String        name;
    private ZonedDateTime createdDateTime;
    
    public Book() {
    }
    
    public Book(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ZonedDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    
    public void setCreatedDateTime(ZonedDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    
}
