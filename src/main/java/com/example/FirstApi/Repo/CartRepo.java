package com.example.FirstApi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstApi.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{
    
}
