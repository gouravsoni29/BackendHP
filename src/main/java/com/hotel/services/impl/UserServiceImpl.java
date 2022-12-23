package com.hotel.services.impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dataclass.BookingData;
import com.hotel.exception.UserFoundException;
import com.hotel.model.Book;
import com.hotel.model.Contact;
import com.hotel.model.Payment;
import com.hotel.model.User;
import com.hotel.model.UserRole;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.ContactRepo;
import com.hotel.repo.PaymentRepo;
import com.hotel.repo.RoleRepository;
import com.hotel.repo.UserRepository;
import com.hotel.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BookingRepo bookingRepo;
    
    @Autowired
    private ContactRepo contactRepo;
    
    @Autowired
    private PaymentRepo paymentRepo;
    
   @Autowired
   private UserService userService;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

	@Override
	public User fetchUserbyEmail(String email) {
		// TODO Auto-generated method stub
		return this.userService.fetchUserbyEmail(email);
	}

	@Override
	public Contact saveContactus(Contact contact) {
		// TODO Auto-generated method stub
		return this.contactRepo.save(contact);
	}

	@Override
	public Book saveBook(BookingData bd) {
		// TODO Auto-generated method stub
		
		Book b1=new Book();
//		b1.setCheckinDate(bd.getCheckinDate());
//		b1.setCheckoutDate(bd.getCheckoutDate());
		b1.setStatus(1);
		
		Book b2=bookingRepo.save(b1);
		Payment payment=new Payment(bd.getPaymentDate(),bd.getPaymentTime());
		payment=paymentRepo.save(payment);
		
		User user=userRepository.findByUserId(bd.getUserId());
		
		b2.setUser(user);
		b2.setPayment(payment);
		
		return bookingRepo.save(b2);
	}

	@Override
	public List<Book> fetchBookingHistory(Long user_id) {
		// TODO Auto-generated method stub
		return bookingRepo.findBookingHistory(user_id);
	}

	@Override
	public List<Book> cancelBooking(Long booking_id) {
		// TODO Auto-generated method stub
		Book b1=bookingRepo.findByBookingId(booking_id);
		b1.setStatus(0);
		return bookingRepo.findBookingHistory(b1.getUser().getId());
	}

	
    
    


}
