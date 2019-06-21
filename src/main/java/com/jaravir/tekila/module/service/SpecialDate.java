package com.jaravir.tekila.module.service;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SpecialDate {
	private final LocalDate date;
	private final DateTimeFormatter dateFormat;
	
	public SpecialDate (String date) {
		this.dateFormat = DateTimeFormat.forPattern(
				"dd-MM"
				);
		this.date = LocalDate.parse(date, this.dateFormat);
	}
	
	public LocalDate getDate() {		
		return new LocalDate(LocalDate.now().getYear(), this.date.getMonthOfYear(), this.date.getDayOfMonth());
	}
	
	public LocalDate getDateForYear(int year) {
		return new LocalDate(year, this.date.getMonthOfYear(), this.date.getDayOfMonth());
	}
	
	public boolean isToday () {
		LocalDate dt = LocalDate.now();
		return this.getDateForYear(dt.getYear()).equals(dt);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SpecialDate)) {
			return false;
		}
		SpecialDate other = (SpecialDate) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.isEqual(other.date)) {
			return false;
		}
	
		return true;
	}
	
	
}
