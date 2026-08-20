package com.example.LoginandRegister.controller;

import com.example.LoginandRegister.model.BuyProduct;
import com.example.LoginandRegister.model.Register;
import com.example.LoginandRegister.repository.RegisRepo;
import com.example.LoginandRegister.service.ServiceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {

    @Autowired
    ServiceSystem serviceSystem;

    @GetMapping("register")
    public List<Register> getRegister() {
        return serviceSystem.getRegister();
    }

    @PostMapping("register")
    public String addDetails(@RequestParam("name") String name, @RequestParam("emailId") String emailId, @RequestParam("password") String password,@RequestParam("phone") String phone,@RequestParam("address") String address) {
        return serviceSystem.addDetails(name, emailId, password,phone,address);
    }

    @PostMapping("/login")
    public String checkValid(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
        return serviceSystem.checkValid(emailId, password);

    }

    @PostMapping("orders")
    public String addOrders(@RequestParam("product") String product, @RequestParam("price") int price, @RequestParam("phone") String phone, @RequestParam("quantity") int quantity, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("email") String email) {
        return serviceSystem.addOrders(product, price, name, address, phone, quantity, email);
    }

    @GetMapping("orders")
    public List<BuyProduct> getBuydetails() {
        return serviceSystem.getBuydetails();
    }

    @GetMapping("myorders")
    public List<BuyProduct> getMyOrders(@RequestParam("email") String email) {
        return serviceSystem.getMyOrders(email);
    }
        @GetMapping("/profile")
        public Object getProfile(@RequestParam String email) {
           return serviceSystem.getProfile(email);

        }

        // ──────────────────────────────────────────────────────────────
        //  POST /profile/update
        //  Params: email, name, phone, address
        //  Returns: "Updated" on success
        //  React call: fetch("http://localhost:8080/profile/update", POST)
        // ──────────────────────────────────────────────────────────────
        @PostMapping("/profile/update")
        public String updateProfile(
                @RequestParam String email,
                @RequestParam String name,
                @RequestParam(required = false) String phone,
                @RequestParam(required = false) String address) {

           return serviceSystem.upadateProfile(email,name,phone,address);
        }

        // ──────────────────────────────────────────────────────────────
        //  POST /profile/changepassword
        //  Params: email, oldPassword, newPassword
        //  Returns: "Changed" | "Wrong password" | "User not found"
        //  React call: fetch("http://localhost:8080/profile/changepassword", POST)
        // ──────────────────────────────────────────────────────────────
        @PostMapping("/profile/changepassword")
        public String changePassword(
                @RequestParam String email,
                @RequestParam String oldPassword,
                @RequestParam String newPassword) {
            return serviceSystem.changePassword(email, oldPassword, newPassword);
        }
    }



