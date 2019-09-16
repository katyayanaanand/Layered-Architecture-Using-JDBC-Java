package com.cg.mps.model;

public class MobileData {

	
	private int id;
	private String name;
	private double cost;
	private int quantity;
	
	
	public MobileData() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MobileData(int id, String name, double cost, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}


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


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "MobileData [id=" + id + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	
}
