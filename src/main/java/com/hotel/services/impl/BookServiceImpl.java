package com.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dataclass.BookingData;
import com.hotel.model.Book;
import com.hotel.model.Payment;
import com.hotel.model.User;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.PaymentRepo;
import com.hotel.repo.UserRepository;
import com.hotel.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Book findByBookingId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book saveBook(BookingData bd) {
		// TODO Auto-generated method stub
		
		Book b1=new Book();
		b1.setCheckinDate(bd.getCheckinDate());
		b1.setCheckoutDate(bd.getCheckoutDate());
		b1.setStatus(1);
		b1.setUsername(bd.getUsername());
		
		Book b2=bookingRepo.save(b1);
		
//		Payment payment =new Payment(bd.getPaymentDate(),bd.getPaymentTime());
//		payment =paymentRepo.save(payment);
		
		User user=userRepository.findByUsername(bd.getUsername());
		
		return bookingRepo.save(b2);
	}

	@Override
	public Book getBooking(String username) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Book getBooking(String username) {
//		// TODO Auto-generated method stub
//		
//		
//	}

}
