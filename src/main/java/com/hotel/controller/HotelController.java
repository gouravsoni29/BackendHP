package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.repo.HotelRepo;


@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class HotelController {
	
	@Lazy
	@Autowired
	private HotelRepo hotelRepo;
	
	@PostMapping("/addHotel")
	public Hotel addHotel(@RequestBody Hotel hotel) throws Exception {
		return hotelRepo.save(hotel);
	}
	
	@GetMapping("/all")
	public List<Hotel> allHotel(){
		return hotelRepo.findAll();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateemp(@PathVariable Long id,@RequestBody Hotel hotel){
		Hotel gethotel = hotelRepo.getById(id);
		gethotel.setHotelName(hotel.getHotelName());
		gethotel.setCity(hotel.getCity());
		gethotel.setRatings(hotel.getRatings());
		
		Hotel updateHotel  = hotelRepo.save(gethotel);
		return ResponseEntity.ok().body(updateHotel);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Hotel>> getHotelbyId(@PathVariable Long id){
		Optional<Hotel> hotel =hotelRepo.findById(id);
		return ResponseEntity.ok(hotel);
				
	}
	
	@DeleteMapping("/delete/{id}")
	public void delHotel(@PathVariable Long id) {
		this.hotelRepo.deleteById(id);
	}
	
	

}
