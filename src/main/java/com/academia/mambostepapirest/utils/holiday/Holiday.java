package com.academia.mambostepapirest.utils.holiday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Holiday {

	private String dateFormat;
	private Date date;
	private String holiday;
	
	public Holiday(int day, int month, int year, String holiday) {
		this.dateFormat=this.dateHolidayFormat(day, month +1, year);
		this.date=this.dateHoliday(this.dateFormat);
		this.holiday=holiday;
	}
	
	
	public String dateHolidayFormat(int day, int month, int year) {
		return year +Fechas.FECHAS_SEPARATOR+formatNumberDigit(month)+Fechas.FECHAS_SEPARATOR+formatNumberDigit(day);
	}
	
	private String formatNumberDigit(int number) {
		return number < 10 ? "0"+number : String.valueOf(number);
	}
	
	private Date dateHoliday(String dateString) {
		 return Fechas.convertStringToDate(dateString);
	    
	    
	}
}
