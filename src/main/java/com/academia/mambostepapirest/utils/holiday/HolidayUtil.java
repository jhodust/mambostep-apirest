package com.academia.mambostepapirest.utils.holiday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HolidayUtil {
    private int year;
    private int easterMonth;
    private int easterDay;
    private Map<String, Holiday> holidays;

    /**
     * Class constructor. Initializes this class with the given year.
     * @param year Year to be used as reference.
     */
    public HolidayUtil(int year) {
    	this.calculateDataYear(year);
    	this.fillHolidays();
    }
    
    
    
    
    private void calculateDataYear(int year) {
    	this.year = year;
    	this.holidays = new HashMap<>();
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        this.easterMonth = (h - m + r + 90) / 25;
        this.easterDay = (h - m + r + this.easterMonth + 19) % 32;
        this.easterMonth--;
        
    }
    
    private  void fillHolidays() {
    	this.createHoliday(0, 1, HolidayName.DIA_ANIO_NUEVO); // Primero de Enero
    	this.calculateEmiliani(0, 6, HolidayName.DIA_REYES_MAGOS);           // Reyes magos 6 de enero
    	this.calculateEmiliani(2, 19, HolidayName.DIA_SAN_JOSE);          //San jose 19 de marzo
    	this.calculateOtherHoliday(-3, false, HolidayName.DIA_JUEVES_SANTO);  //jueves santos
    	this.calculateOtherHoliday(-2, false, HolidayName.DIA_VIERNES_SANTO);  //viernes santo
    	this.createHoliday(4, 1, HolidayName.DIA_TRABAJADOR); // Dia del trabajo 1 de mayo
    	this.calculateOtherHoliday(40, true, HolidayName.DIA_ASCENSION);   //Asención del señor de pascua
    	this.calculateOtherHoliday(60, true, HolidayName.DIA_CORPUS_CHRISTI);   //Corpus cristi
    	this.calculateOtherHoliday(68, true, HolidayName.DIA_SAGRADO_CORAZON);   //Sagrado corazon
    	this.calculateEmiliani(5, 29, HolidayName.DIA_SAN_PEDRO);          //San pedro y san pablo 29 de junio
    	this.createHoliday(6,20, HolidayName.DIA_INDEPENDENCIA); //Independencia 20 de Julio
    	this.createHoliday(7,7, HolidayName.DIA_BATALLA_BOYACA); //Batalla de boyaca 7 de agosto
    	this.calculateEmiliani(7, 15, HolidayName.DIA_ASUNCION);          //Asuncion 15 de agosto
    	this.calculateEmiliani(9, 12, HolidayName.DIA_RAZA);          //Descubrimiento de america 12 de octubre
    	this.calculateEmiliani(10, 1, HolidayName.DIA_TODOS_SANTOS);          //Todos los santos 1 de noviembre
    	this.calculateEmiliani(10, 11, HolidayName.DIA_INDEPENDENCIA_CARTAGENA);         //Independencia de cartagena 11 de noviembre
    	this.createHoliday(11,8, HolidayName.DIA_INMACULADA_CONCEPCION); //Maria inmaculada 8 de diciembre
    	this.createHoliday(11,25, HolidayName.DIA_NAVIDAD); //Navidad 25 de diciembre
    	
    }
    
    private void createHoliday(int month, int day, String holidayName) {
    	Holiday holiday= new Holiday(day, month , this.year, holidayName);
    	this.holidays.put(holiday.getDateFormat(), holiday);
    }

    
    /**
     * Move a holiday to monday by emiliani law
     * @param month Original month of the holiday
     * @param day Original day of the holiday
     */
    private void calculateEmiliani(int month, int day, String holidayName) {
        Calendar date = Calendar.getInstance();
        date.set(this.year, month, day);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                date.add(Calendar.DATE, 1);
                break;
            case 3:
                date.add(Calendar.DATE, 6);
                break;
            case 4:
                date.add(Calendar.DATE, 5);
                break;
            case 5:
                date.add(Calendar.DATE, 4);
                break;
            case 6:
                date.add(Calendar.DATE, 3);
                break;
            case 7:
                date.add(Calendar.DATE, 2);
                break;
            default:
                break;
        }
        
        this.createHoliday(date.get(Calendar.MONTH), date.get(Calendar.DATE), holidayName);
        
    }

    /**
     * Calculate holidays according to easter day
     * @param days Number of days after (+) or before (-) of easter day
     * @param emiliani Indicates whether the emiliani law affects
     */
    private void calculateOtherHoliday(int days, boolean emiliani, String holidayName) {
        Calendar date = Calendar.getInstance();
        date.set(this.year, this.easterMonth, this.easterDay);
        date.add(Calendar.DATE, days);
        if (emiliani) {
        	this.calculateEmiliani(date.get(Calendar.MONTH), date.get(Calendar.DATE),holidayName);
        } else {
        	this.createHoliday(date.get(Calendar.MONTH), date.get(Calendar.DATE), holidayName);
        }
    }

    /**
     * Indicates if a day is a holiday
     * @param month Month in which the day is contained
     * @param day Day to evaluate
     * @return true if the day is a holiday, false otherwise
     */
    public boolean isHoliday(String strDate) {
    	return this.holidays.containsKey(strDate);
    }

    /**
     * Get the year
     * @return int representation of the year
     */
    public int getYear() {
        return year;
    }

   
}