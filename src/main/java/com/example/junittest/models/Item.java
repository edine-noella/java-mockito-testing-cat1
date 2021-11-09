package com.example.junittest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Item {
    @Id
    private Integer Id;
    private String itemName;
    private Integer price;

    public Item() {
    }

    public Item(Integer id, String itemName, Integer price) {
        Id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
