package com.hotel.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dataclass.BookingData;
import com.hotel.exception.UserFoundException;
import com.hotel.model.Book;
import com.hotel.model.Contact;
import com.hotel.model.Role;
import com.hotel.model.User;
import com.hotel.model.UserRole;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.ContactRepo;
import com.hotel.repo.PaymentRepo;
import com.hotel.services.UserService;
import com.hotel.services.impl.UserDetailsServiceImpl;
import com.hotel.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private BookingRepo bookingRepo;
    
    @Autowired
    private ContactRepo contactRepo;
    
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {


        user.setProfile("default.png");
        //encoding password with bcryptpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);


        return this.userService.createUser(user, roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    //update api


    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
    
	@PostMapping("/contactus")
	public Contact saveStudent(@RequestBody Contact contact) throws Exception
	{
		Contact obj=userServiceImpl.saveContactus(contact);
		
		return obj;
	}
	
	@PostMapping("/save_booking")
	public Book saveBooking(@RequestBody BookingData booking) throws Exception
	{
		Book obj=userServiceImpl.saveBook(booking);
		
		return obj;
	}
	
	@GetMapping("/get_history")
	public List<Book> getBookingHistory(@RequestParam Long user_id) 
	{
			//System.out.println("s="+source+" d="+desOtination+" t"+type);
			List<Book> obj=userServiceImpl.fetchBookingHistory(user_id);
			//System.out.println("list="+obj);
			return obj;
	}
	
	@GetMapping("/cancel_booking")
	public List<Book> cancelBooking(@RequestParam Long booking_id) 
	{
			//System.out.println("s="+source+" d="+destination+" t"+type);
			List<Book> obj=userServiceImpl.cancelBooking(booking_id);
			//System.out.println("list="+obj);
			return obj;
	}
	
    
    
    
    


}
