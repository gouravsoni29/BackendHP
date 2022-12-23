package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
