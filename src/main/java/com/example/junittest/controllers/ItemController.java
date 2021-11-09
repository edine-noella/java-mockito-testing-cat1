package com.example.junittest.controllers;

import com.example.junittest.models.Item;
import com.example.junittest.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/get-all-items")
    public List<Item> getAll(){
        return itemService.getAllItems();
    }

    @PostMapping("/add-Items")
    public Item createCart(@RequestBody Item item){
        return itemService.createItem(item.getId(),item.getItemName(),item.getPrice());
    }

}
