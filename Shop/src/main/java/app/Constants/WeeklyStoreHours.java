package app.Constants;

import java.time.LocalTime;

public enum WeeklyStoreHours {
	MONDAY		("Monday", 		9, 00, 20, 00),
	TUESDAY		("Tuesday"),  	//Closed
	WEDNESDAY	("Wednesday",  	9, 00, 20, 00), 
	THURSDAY	("Thursday",  	9, 00, 20, 00), 
	FRIDAY		("Friday",  	9, 00, 22, 00), 
	SATURDAY	("Saturday",  	9, 00, 22, 00), 
	SUNDAY		("Sunday",  	9, 00, 22, 00);
	
	private String name;
	private boolean opens;
	private LocalTime openingTime, closingTime;
	
	WeeklyStoreHours(String name, LocalTime openingTime, LocalTime closingTime){
		setName(name);
		this.opens = true;
		setOpeningTime(openingTime);
		setClosingTime(closingTime);
	}
	
	WeeklyStoreHours(String name, int openHour, int openMinute, int closeHour, int closeMinute){
		setName(name);
		setOpeningTime(openHour, openMinute);
		setClosingTime(closeHour, closeMinute);
	}
	
	WeeklyStoreHours(String name) {
		setName(name);
		this.opens = false;
		setOpeningTime(null);
		setClosingTime(null);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(int hour, int minute) {
		this.openingTime = LocalTime.of(hour, minute);
	}
	
	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(int hour, int minute) {
		this.closingTime = LocalTime.of(hour, minute);
	}
	
	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}
	
	public boolean getOpens() {
		return opens;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
