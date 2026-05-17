package com.example.LoginandRegister.service;

import com.example.LoginandRegister.model.BuyProduct;
import com.example.LoginandRegister.model.Register;
import com.example.LoginandRegister.repository.OrderRepo;
import com.example.LoginandRegister.repository.RegisRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceSystem {

    @Autowired
    RegisRepo regisRepo;

    @Autowired
    OrderRepo orderRepo;
    public List<Register> getRegister() {
        return regisRepo.findAll();
    }

    public String addDetails(String name, String emailId, String password) {
        Register register=new Register(name,emailId,password);
        regisRepo.save(register);
        return "Added";
    }

    public String checkValid(String emailId, String password) {
        Register register=regisRepo.findByEmailId(emailId);
        if(register==null)return "email not exits";
        if(register.getEmailId().equals(emailId)){
            if(register.getPassword().equals(password)){
                return "Success";
            } else {
                return "Invalid password";
            }

        } else {
            return "Invalid email";
        }
    }



    public List<BuyProduct> getBuydetails() {
        return orderRepo.findAll();
    }

    public String addOrders(String product, int price,String name, String address, String phone, int quantity,String email) {
        BuyProduct buyProduct=new BuyProduct(product,price,name, address, phone, quantity,email);
        orderRepo.save(buyProduct);
        return "Order succeefully";
    }

    public List<BuyProduct> getMyOrders(String email) {
        return orderRepo.findByEmail(email);
    }
}
