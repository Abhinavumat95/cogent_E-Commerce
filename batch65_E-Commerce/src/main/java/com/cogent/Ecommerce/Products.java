package com.cogent.Ecommerce;

public class Products {
	
	int id;
	String name;
	float cost;
	float discount;
	int available;
	int sold;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int id, String name, float cost, float discount, int available, int sold) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
		this.available = available;
		this.sold = sold;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", cost=" + cost + ", discount=" + discount + ", available="
				+ available + ", sold=" + sold + "]";
	}
	
	

}
