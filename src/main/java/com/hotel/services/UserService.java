package com.hotel.services;



import java.util.List;
import java.util.Set;

import com.hotel.dataclass.BookingData;
import com.hotel.model.Book;
import com.hotel.model.Contact;
import com.hotel.model.User;
import com.hotel.model.UserRole;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);
    
    
    //fetch user by email
    public User fetchUserbyEmail(String email);
    
    //save contact message
    public Contact saveContactus(Contact contact);
    
    //for booking
    public Book saveBook(BookingData bd);
    
    //for fetch booking based on userId
    public List<Book> fetchBookingHistory(Long user_id);
    
    
    //for cancel the booking by bookingId
    public List<Book> cancelBooking(Long booking_id);
}
