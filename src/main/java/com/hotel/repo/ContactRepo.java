package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long>{

}
