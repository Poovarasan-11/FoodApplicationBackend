package com.example.LoginandRegister.controller;

import com.example.LoginandRegister.model.BuyProduct;
import com.example.LoginandRegister.model.Register;
import com.example.LoginandRegister.service.ServiceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class Controller {

    @Autowired
    ServiceSystem serviceSystem;

    @GetMapping("register")
    public List<Register> getRegister(){
        return serviceSystem.getRegister();
    }

    @PostMapping("register")
    public String addDetails(@RequestParam("name") String name,@RequestParam("emailId") String emailId,@RequestParam("password") String password){
        return serviceSystem.addDetails(name,emailId,password);
    }

    @PostMapping("/login")
    public String checkValid(@RequestParam("emailId") String emailId,@RequestParam("password") String password){
       return serviceSystem.checkValid(emailId,password);

    }

    @PostMapping("orders")
    public String addOrders(@RequestParam("product") String product,@RequestParam("price") int price,@RequestParam("phone") String phone,@RequestParam("quantity") int quantity,@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("email") String email){
        return serviceSystem.addOrders(product,price,name,address,phone,quantity,email);
    }

    @GetMapping("orders")
    public List<BuyProduct> getBuydetails(){
        return serviceSystem.getBuydetails();
    }
    @GetMapping("myorders")
    public List<BuyProduct> getMyOrders(@RequestParam("email") String email){
        return serviceSystem.getMyOrders(email);
    }
}
