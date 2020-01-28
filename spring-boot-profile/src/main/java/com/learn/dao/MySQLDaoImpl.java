package com.learn.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("qa")
public class MySQLDaoImpl implements TestDao {
    
    @Override
    public void save() {
        System.out.println("Saving MySQL...");
        
    }
    
    @Override
    public String get() {
        System.out.println("Getting...");
        return "MySQL";
    }
    
}
