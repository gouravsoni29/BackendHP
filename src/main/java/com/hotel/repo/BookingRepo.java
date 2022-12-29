package com.hotel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.model.Book;
import com.hotel.model.User;

@Repository
public interface BookingRepo extends JpaRepository<Book, Long> {
	@Query(value = "SELECT * FROM bookings b WHERE b.user_id=?1", nativeQuery = true)
	List<Book> findBookingHistory(Long user_id);
	
	Book findByBookingId(Long id);
	public User findByUsername(String username);

}
