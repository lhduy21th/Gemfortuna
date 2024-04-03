package com.gems.fortuna.service;


import com.gems.fortuna.utlis.ShoppingCart;

public interface CartService {
    void addProduct(long id);
    boolean removeProduct(long id);
    long checkout();
    ShoppingCart getCart();
}
