package com.gems.fortuna.service;


import com.gems.fortuna.model.User;

import java.util.Optional;

public interface UserDaoService {
    Optional<User> selectUserByUsername(String username);
}
