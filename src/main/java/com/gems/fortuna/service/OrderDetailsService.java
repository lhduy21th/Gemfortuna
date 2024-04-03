package com.gems.fortuna.service;

import com.gems.fortuna.model.OrderDetails;
import com.gems.fortuna.model.Product;

import java.util.List;
import java.util.Map;

public interface OrderDetailsService {
    OrderDetails get(long id);
    List<OrderDetails> getUserOrders(String username);
    long save(List<Product> products);
    List<Product> populateProducts(Map<Long, Integer> cart);
}
