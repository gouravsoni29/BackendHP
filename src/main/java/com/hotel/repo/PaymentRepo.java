package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
