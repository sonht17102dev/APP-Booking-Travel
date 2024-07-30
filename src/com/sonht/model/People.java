package com.sonht.model;

public class People {
	private int id;
	private String name;
	private double price;

	public People(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
