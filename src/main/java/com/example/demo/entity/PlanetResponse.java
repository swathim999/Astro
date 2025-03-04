package com.example.demo.entity;



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


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getTimezone() {
		return timezone;
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
