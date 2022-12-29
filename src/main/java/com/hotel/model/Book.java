package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "bookings")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
	private Long bookingId;
	private String checkinDate;
	private String checkoutDate;
	private Integer status;
	private String username;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
//	private User user;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
//	private Hotel hotel;
//	
//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "Book")
//@JoinColumn(name = "payment_id", referencedColumnName = "bookingId")
//private Payment payment;
////	
	
	

	public Book() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}


////
//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}


	
	
}
