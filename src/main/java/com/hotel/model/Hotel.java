package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
	private long id;
	private String hotelName;
	private long price;
	private String city;
	private double ratings;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	public Hotel(long id, String hotelName, long price, String city, double ratings) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.price = price;
		this.city = city;
		this.ratings = ratings;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
