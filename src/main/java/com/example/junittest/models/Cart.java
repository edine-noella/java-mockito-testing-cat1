package com.example.junittest.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
    @Id
    private Integer id;

//    @Dao
//    public interface UserDao {
//        @Query("CREATE TRIGGER Items.insert ON Items AFTER INSERT AS BEGIN "
//                +"UPDATE Carts SET Carts.totalPrice=cart.totalPrice+Items.price && Carts.numberOfItems=Carts.numberOfItems+1"+
//                "END")
//        public LiveData<List<UserBook>> loadUserAndBookNames();
//    }

    private Integer numberOfItems;

    private Integer totalPrice;

    public Cart() {
    }

    public Cart(Integer numberOfItems, Integer totalPrice) {
        this.numberOfItems = numberOfItems;
        this.totalPrice = totalPrice;
    }

    public Cart(Integer id, Integer numberOfItems, Integer totalPrice) {
        this.id = id;
        this.numberOfItems = numberOfItems;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
