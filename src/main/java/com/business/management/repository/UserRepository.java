package com.business.management.repository;

import com.business.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String Email);
}
