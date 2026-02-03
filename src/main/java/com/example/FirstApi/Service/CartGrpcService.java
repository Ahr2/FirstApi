package com.example.firstapi.Service;

import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.firstapi.Model.Cart;          // ✅ JPA entity
import com.example.firstapi.Repo.CartRepo;       // ✅ JPA repo

// ✅ gRPC generated classes
import com.example.firstapi.grpc.CartServiceGrpc;
import com.example.firstapi.grpc.UpdateCartRequest;
import com.example.firstapi.grpc.UpdateCartResponse;

@GrpcService
public class CartGrpcService
        extends CartServiceGrpc.CartServiceImplBase {

    @Autowired
    private CartRepo cartRepo;

    @Override
    public void updateCart(
            UpdateCartRequest request,
            StreamObserver<UpdateCartResponse> responseObserver) {

        // gRPC → JPA mapping
        Cart cart = new Cart();
        cart.setId(request.getId());
        cart.setName(request.getName());
        cart.setAge(request.getAge());

        if (request.getId() <= 0) {
            throw new IllegalArgumentException("Invalid Cart ID");
        }

        // Save ONE entity
        cartRepo.save(cart);

        // gRPC response
        UpdateCartResponse response = 
                UpdateCartResponse.newBuilder()
                        .setMessage("Cart updated successfully")
                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}