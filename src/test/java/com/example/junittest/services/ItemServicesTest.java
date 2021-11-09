package com.example.junittest.services;


import com.example.junittest.models.Item;
import com.example.junittest.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;


    @Test
    public void getAllCarts(){
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1,"shirt",10000),new Item(2,"car",12000000),new Item(3,"notebook",3000)));
        assertEquals("Other",itemService.getAllItems().get(2).getPrice());
    }

    @Test
    public  void createCart(){
        when(itemRepository.save(ArgumentMatchers.any(Item.class))).thenReturn(new Item(1,"shoes",1000));
        assertEquals(1000,itemService.createItem(5,"races",40000).getPrice());

    }
    @Test
    public void deleteItem(){
        Item status = new Item(5,"torch",89000);
        when(itemRepository.findById(status.getId())).thenReturn(Optional.of(status));

        itemService.deleteItem(status.getId());

        verify(itemRepository).deleteById(status.getId());

    }


}
