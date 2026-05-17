package com.example.LoginandRegister.repository;

import com.example.LoginandRegister.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisRepo extends JpaRepository<Register,Integer> {

    public Register findByEmailId(String emailId);

}
