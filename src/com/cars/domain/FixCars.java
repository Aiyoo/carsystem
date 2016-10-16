package com.cars.domain;

//import java.util.Date;

public class FixCars {
	private int carid;
	private String username;
	private String carname;
	private String type;
	private String fixreason;
	private double price;
	private String indate;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFixreason() {
		return fixreason;
	}
	public void setFixreason(String fixreason) {
		this.fixreason = fixreason;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
