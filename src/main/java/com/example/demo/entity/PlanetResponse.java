package com.example.demo.entity;


import lombok.Getter;

@Getter
public class PlanetResponse {
	private int year; 
	private int month;
	private int date;
	private int hours;
	private int minutes; 
	private int seconds; 
	private float latitude;
	private float longitude;
	private float timezone;

	// ✅ Getters and Setters

    public void setYear(int year) {
		this.year = year;
	}

    public void setMonth(int month) {
		this.month = month;
	}

    public void setDate(int date) {
		this.date = date;
	}

    public void setHours(int hours) {
		this.hours = hours;
	}

    public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

    public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

    public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

    public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

    public void setTimezone(float timezone) {
		this.timezone = timezone;
	}

	// ✅ toString() method

	@Override
	public String toString() {
		return "PlanetResponse{" +
				"year=" + year +
				", month=" + month +
				", date=" + date +
				", hours=" + hours +
				", minutes=" + minutes +
				", seconds=" + seconds +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", timezone=" + timezone +
				'}';
	}

	// ✅ No-argument constructor (required for deserialization)
	public PlanetResponse() {
	}
}
