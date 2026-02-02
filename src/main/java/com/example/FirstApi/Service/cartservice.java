package com.example.firstapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapi.Model.Cart;
import com.example.firstapi.Repo.CartRepo;

@Service
public class cartservice {
    
    @Autowired
    private CartRepo cartRepo;

    public List<Cart> getallproducts(){
        return cartRepo.findAll();
    }
    public String addproduct(Cart cart){
        cartRepo.save(cart);
        return "Product created successfully";
    }

    public void updateproduct(Cart cart) {

    Cart existing = cartRepo.findById(cart.getId())
        .orElseThrow(() -> new RuntimeException("Product not found"));

    existing.setName(cart.getName());
    existing.setAge(cart.getAge());
    cartRepo.save(existing);
   }
}
