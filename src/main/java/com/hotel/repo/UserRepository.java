package com.hotel.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    public User findByUserId(Long id);
   
}
