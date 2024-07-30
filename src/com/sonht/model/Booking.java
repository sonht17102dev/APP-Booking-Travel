package com.sonht.model;

public class Booking {
	private int id;
	private int userId;
	private int tourId;
	private String createdDate;
	private String status;

	public Booking(int id, int userId, int tourId, String createdDate, String status) {
		this.id = id;
		this.userId = userId;
		this.tourId = tourId;
		this.createdDate = createdDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getTourId() {
		return tourId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", tourId=" + tourId + ", createdDate=" + createdDate
				+ ", status=" + status + "]";
	}

}
