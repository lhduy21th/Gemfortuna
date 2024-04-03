package com.gems.fortuna.repository;

import com.gems.fortuna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
