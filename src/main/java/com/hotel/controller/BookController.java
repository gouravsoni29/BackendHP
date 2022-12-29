package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dataclass.BookingData;
import com.hotel.model.Book;
import com.hotel.model.Payment;
import com.hotel.model.User;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.PaymentRepo;
import com.hotel.services.UserService;
import com.hotel.services.impl.BookServiceImpl;
import com.hotel.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private PaymentRepo paymentRepo;
	
	
	@PostMapping("/savebook")
	public Book saveBooking(@RequestBody BookingData booking) throws Exception{
		Book obj=bookServiceImpl.saveBook(booking);
		return obj;
	}
	
	@GetMapping("/all")
	public List<Book> allBooking(){
		return bookingRepo.findAll();
	}
	
	 @GetMapping("/{username}")
	    public User getUser1(@PathVariable("username") String username) {
	        return this.userService.getUser(username);
	    }
	 
	 @PostMapping("/payment")
	 public Payment savepay(@RequestBody Payment payment) {
		 return paymentRepo.save(payment);
	 }
	 
	 @GetMapping("/allpayment")
	 public List<Payment> allpayment(){
		 return paymentRepo.findAll();
	 }
//	@GetMapping("/cancel_booking")
//	public List<Book> cancelBooking(@RequestParam Long booking_id) 
//	{
//			//System.out.println("s="+source+" d="+destination+" t"+type);
//			List<Book> obj=userServiceImpl.cancelBooking(booking_id);
//			//System.out.println("list="+obj);
//			return obj;
//	}
	
	
}
