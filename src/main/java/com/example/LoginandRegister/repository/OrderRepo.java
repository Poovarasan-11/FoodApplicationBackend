package com.example.LoginandRegister.repository;

import com.example.LoginandRegister.model.BuyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<BuyProduct,Integer> {

    public List<BuyProduct> findByEmail(String email);

    long countByEmail(String email);
}
