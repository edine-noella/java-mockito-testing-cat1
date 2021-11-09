package com.example.junittest.services;


import com.example.junittest.models.Cart;
import com.example.junittest.repository.CartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServicesTest {

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartService cartService;


    @Test
    public void getAllCarts(){
        when(cartRepository.findAll()).thenReturn(Arrays.asList(new Cart(1,1,1000),new Cart(2,2,2000),new Cart(3,3,3000)));
        assertEquals(2000,cartService.getAllCarts().get(2).getTotalPrice());
    }

    @Test
    public  void createCart(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(new Cart(1,23,1000));
        assertEquals(1000,cartService.createCart(5,4,40000).getTotalPrice());

    }
    @Test
    public void deleteCart(){
        Cart status = new Cart(5,25,89000);
        when(cartRepository.findById(status.getId())).thenReturn(Optional.of(status));

        cartService.deleteCart(status.getId());

        verify(cartRepository).deleteById(status.getId());

    }


}
