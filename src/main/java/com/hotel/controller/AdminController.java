package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Book;
import com.hotel.model.Hotel;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.HotelRepo;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@GetMapping("/allbookings")
	public List<Book> getAllBooking(){
		return bookingRepo.findAll();
	}
	
	@GetMapping("/hotellist")
	public List<Hotel> getAllHotel(){
		return hotelRepo.findAll();
	}
	
	@PostMapping("/addhotel")
	public Hotel addEmp(@RequestBody Hotel hotel) {
		Hotel gethotel=hotelRepo.save(hotel);
		return gethotel;
	}
	

}
