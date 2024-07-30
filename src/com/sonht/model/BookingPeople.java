package com.sonht.model;

public class BookingPeople {
	private int id;
	private int bookingId;
	private int peopleId;
	private int quantity;

	public BookingPeople(int id, int bookingId, int peopleId, int quantity) {
		this.id = id;
		this.bookingId = bookingId;
		this.peopleId = peopleId;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookingPeople [id=" + id + ", bookingId=" + bookingId + ", peopleId=" + peopleId + ", quantity="
				+ quantity + "]";
	}

	public int getId() {
		return id;
	}

	public int getBookingId() {
		return bookingId;
	}

	public int getPeopleId() {
		return peopleId;
	}

	public int getQuantity() {
		return quantity;
	}

}
