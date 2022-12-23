package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
	private long id;
	private String hotelName;
	private String City;
	private long ratings;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public long getRatings() {
		return ratings;
	}
	public void setRatings(long ratings) {
		this.ratings = ratings;
	}
	public Hotel(long id, String hotelName, String city, long ratings) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		City = city;
		this.ratings = ratings;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
