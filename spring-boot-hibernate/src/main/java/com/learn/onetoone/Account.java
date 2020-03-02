package com.learn.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    private Long   id;
    private Long   accountNumber;
    private String bankName;
    private String ifscCode;
    
    @OneToOne(mappedBy = "account")
    private Employee employee;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public String getIfscCode() {
        return ifscCode;
    }
    
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
