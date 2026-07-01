package com.example.LoginandRegister.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String emailId;
    private String password;
    // 1. NEW field
    private String phone;

    // 2. NEW field
    private String address;

    // 3. NEW getter + setter for phone
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    // 4. NEW getter + setter for address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Register(String name, String emailId, String password, String phone, String address) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Register() {
    }


}
