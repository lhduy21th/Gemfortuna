package com.gems.fortuna.service;


import com.gems.fortuna.model.User;

public interface UserService {
    String save(User user);
    User getByUsername(String username);
    boolean existsByUsername(String username);
}
