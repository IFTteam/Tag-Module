package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User findById(long l);
}
