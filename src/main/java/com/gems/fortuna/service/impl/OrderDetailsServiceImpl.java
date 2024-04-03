package com.gems.fortuna.service.impl;

import com.gems.fortuna.model.OrderDetails;
import com.gems.fortuna.model.Product;
import com.gems.fortuna.repository.OrderDetailsRepository;
import com.gems.fortuna.service.OrderDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductServiceImpl productServiceImpl;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, ProductServiceImpl productServiceImpl) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.productServiceImpl = productServiceImpl;
    }

    public OrderDetails get(long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public List<OrderDetails> getUserOrders(String username) {
        return orderDetailsRepository.getUserOrders(username);
    }

    public long save(List<Product> products) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setClient(SecurityContextHolder.getContext().getAuthentication().getName());
        products.forEach(product -> {
            orderDetails.setTotal(orderDetails.getTotal().add(product.getPrice().multiply(new BigDecimal(product.getQuantity()))));
            orderDetails.getProducts().put(product.getId(), product.getQuantity());
        });
        return orderDetailsRepository.save(orderDetails).getId();
    }

    public List<Product> populateProducts(Map<Long, Integer> cart) {
        List<Product> products = new ArrayList<>();
        cart.keySet().forEach(
                id -> productServiceImpl.get(id)
                        .ifPresent(product -> {
                            product.setQuantity(cart.get(id));
                            products.add(product);
                        })
        );
        return products;
    }

}
