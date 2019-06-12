package com.depaul.cdm.se452.group6.movie.utility;

import com.depaul.cdm.se452.group6.movie.entity.Cart;

import java.io.Serializable;
import java.util.Date;

public class HistoryEntry implements Serializable {

    private String timestamp;

    private Cart cart;


    public String getDate(){
        return timestamp;
    }

    public Cart getCart(){
        return cart;
    }

    public void setDate(String date){
        timestamp = date;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

}
