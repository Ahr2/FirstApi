package com.example.firstapi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapi.Model.Cart;
import com.example.firstapi.Service.cartservice;

@RestController
public class cartcontroller {
    
    @Autowired
    private cartservice cartService;

    @GetMapping("/allproducts")
    public List<Cart> getallproducts(){
        return cartService.getallproducts();   
    }
    
    @PostMapping("/addproduct/{id}")
    public ResponseEntity<String> addproduct(@PathVariable int id, @RequestBody Cart cart){
        cartService.addproduct(cart);

        return ResponseEntity.status(HttpStatus.CREATED).body("Product Created successfully");
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<String> updateproduct( @RequestBody Cart cart){
        cartService.updateproduct(cart);
        return ResponseEntity.status(HttpStatus.OK).body("Product update Successfully");
    }

    @GetMapping("/getproductbyid/{id}")
    public String getproductbyid(@PathVariable int id){
        return cartService.getproductbyid(id);
    }

}

/*
DB_URL : jdbc:mysql://yamanote.proxy.rlwy.net:28060/railway
DB_USERNAME : root
DB_PASSWORD : yBrWfdbxASwyJNAwakSwRMWlagjMfNUa

*/