package com.hotel.services;

import java.util.List;

import com.hotel.dataclass.BookingData;
import com.hotel.model.Book;

public interface BookService {
	
	Book findByBookingId(Long id);
	
	public Book saveBook(BookingData bd);
	
	public Book getBooking(String username);


}
