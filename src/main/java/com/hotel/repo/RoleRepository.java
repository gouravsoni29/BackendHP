package com.hotel.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
