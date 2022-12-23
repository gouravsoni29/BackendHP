package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long>{

}
