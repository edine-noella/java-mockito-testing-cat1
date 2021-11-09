package com.example.junittest.services;

import com.example.junittest.models.Item;
import com.example.junittest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {

    @Autowired
    ItemRepository ItemRepository;

    //get all Items
    public List<Item> getAllItems(){
        return ItemRepository.findAll();
    }

    //create Item
    public Item createItem(Integer id, String itemName, Integer price){
        Item cart = new Item(id, itemName, price);

        return ItemRepository.save(cart);
    }

    //delete cart
    public void deleteItem(Integer id){
        ItemRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Item not found with id"+ id));
        ItemRepository.deleteById(id);
    }

}