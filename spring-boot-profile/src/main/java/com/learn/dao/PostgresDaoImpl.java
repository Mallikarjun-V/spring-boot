package com.learn.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class PostgresDaoImpl implements TestDao {
    
    @Override
    public void save() {
        System.out.println("Saving Postgres...");
        
    }
    
    @Override
    public String get() {
        System.out.println("Getting...");
        return "Postres";
    }
    
}
