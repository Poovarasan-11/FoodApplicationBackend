package com.example.LoginandRegister.service;

import com.example.LoginandRegister.model.BuyProduct;
import com.example.LoginandRegister.model.ProfileDTO;
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

    public String addDetails(String name, String emailId, String password,String phone,String address) {
        Register register=new Register(name,emailId,password,phone,address);
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


    public String changePassword(String email, String oldPassword, String newPassword) {
        Register register= regisRepo.findByEmailId(email);
        if(register==null)return "User not found";


        // Plain-text check (matches your existing login logic)
        // If you use BCrypt later, replace with: passwordEncoder.matches(oldPassword, user.getPassword())
        if (!register.getPassword().equals(oldPassword)) {
            return "Wrong password";
        }

        register.setPassword(newPassword);
        regisRepo.save(register);
        return "Changed";
    }

    public Object getProfile(String email) {
        Register register = regisRepo.findByEmailId(email);

        if(register==null)return new Register("null","null","null","null","null");;
        long totalOrders = orderRepo.countByEmail(email);

        return new ProfileDTO(
                register.getName(),
                register.getEmailId(),
                register.getPhone(),
                register.getAddress(),
                totalOrders
        );
    }

    public String upadateProfile(String email, String name, String phone, String address) {
         Register register = regisRepo.findByEmailId(email);

        if(register==null)return "User not found";
        register.setName(name);

        if (phone != null) register.setPhone(phone);
        if (address != null) register.setAddress(address);

        regisRepo.save(register);
        return "Updated";
    }
}

