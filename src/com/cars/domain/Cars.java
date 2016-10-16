package com.cars.domain;

public class Cars {
	private int carid;
	private String carname;
	private String type;
	private String images;
	private double price;
	private String intro;
	private int carcount;
	public int getCarcount() {
		return carcount;
	}
	public void setCarcount(int carcount) {
		this.carcount = carcount;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	
}
