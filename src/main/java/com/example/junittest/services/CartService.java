package com.example.junittest.services;

import com.example.junittest.models.Cart;
import com.example.junittest.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    //get all carts
    public  List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    //create cart
    public Cart createCart(Integer id,Integer numberOfItems, Integer totalPrice){
        Cart cart = new Cart(id, numberOfItems, totalPrice);

        return cartRepository.save(cart);
    }

    //delete cart
    public void deleteCart(Integer id){
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("cart not found with id"+ id));
         cartRepository.deleteById(id);
    }


}
