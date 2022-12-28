package app.Constants;

import java.time.DateTimeException;
import java.time.MonthDay;

public enum Holidays {
	NEWYEARSDAY("New Years Day", 1, 1),
	MLKDAY("Martin Luther King Day", 1, 20),
	PRESIDENTSDAY("Presidents' Day", 2, 17),
	MEMORIALDAY("Memorial Day", 3, 25),
	INDEPENDANCEDAY("Independance Day", 6, 4),
	LABORDAY("Labor Day", 10, 7),
	VETERANSDAY("Veterans Day", 11, 11),
	THANKSGIVING("Thanksgiving", 11, 26),
	CHRISTMASEVE("Christmas Eve", 12, 24),
	CHRISTMAS("Christmas", 12, 25),
	NEWYEARSEVE("New Year's Eve", 12, 31);
	
	String name;
	MonthDay monthDay;
	
	Holidays(String name, int month, int day){
		this.name = name;
		setMonthDay(month, day);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MonthDay getMonthDay() {
		return monthDay;
	}

	public void setMonthDay(int Month, int Day) throws DateTimeException{
		this.monthDay = MonthDay.of(Month, Day);
	}
	
	public void setMonthDay(MonthDay monthDay) {
		this.monthDay = monthDay;
	}
	
	@Override
	public String toString() {
		return name;
	}
}