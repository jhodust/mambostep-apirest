package com.academia.mambostepapirest.utils.holiday;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Fechas {

	public static final String FECHAS_SEPARATOR="-";
	public static final String FORMAT_DATE="yyyy"+FECHAS_SEPARATOR+"MM"+FECHAS_SEPARATOR+"dd";
	public static String calculateFechaFinMensualidad(String fechaInicioMensualidad, String diasHabilesMensualidad) {
		int diasHabiles=Integer.parseInt(diasHabilesMensualidad);
		int dia=0;
		
		
		Date fechaInicio= Fechas.convertStringToDate(fechaInicioMensualidad);
		Calendar calendario= Calendar.getInstance();
		calendario.setTime(fechaInicio);
		while(dia < diasHabiles) {
		      if(calendario.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendario.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY 
		     &&  !Fechas.isHoliday(Fechas.convertDateToStringOnlyDate(calendario.getTime()))){

		        dia++;
		        System.out.println("dia que lleva");
		        System.out.println(calendario.getTime());
		        System.out.println(dia);
		        System.out.println("-----------------------------");
		        if(dia == diasHabiles){
		          break;
		        }
		      }
		      
		      calendario.add(Calendar.DATE, 1);
		      
		    }
		
		return Fechas.convertDateToStringOnlyDate(calendario.getTime());
	}
	
	private static boolean isHoliday(String strDate) {
		HolidayUtil currentYear=new HolidayUtil(Calendar.getInstance().get(Calendar.YEAR));
		HolidayUtil nextYear=new HolidayUtil(Calendar.getInstance().get(Calendar.YEAR) +1);
		return currentYear.isHoliday(strDate) || nextYear.isHoliday(strDate);
	}
	public static Date convertStringToDate(String dateString) {
		
		    Date date;
			try {
				date = new SimpleDateFormat(FORMAT_DATE).parse(dateString);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			return null;
		    
	
	}
	
	
	
	public static String convertDateToStringOnlyDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
}
