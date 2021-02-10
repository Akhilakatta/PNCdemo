package com.pnc.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNTDETAILS")
public class AccountDetails {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "ACCOUNT_NUM")
    private String accountNumber;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column (name = "UPDATE_DATE")
    private LocalDateTime lastUpdatedTimeStamp;

    @Column (name = "BALANCE")
    private double balance;

    @Column (name = "TYPE")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public void setLastUpdatedTimeStamp(LocalDateTime lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}