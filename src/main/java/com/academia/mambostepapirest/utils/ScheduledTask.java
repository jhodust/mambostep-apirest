package com.academia.mambostepapirest.utils;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dao.IClaseDictadaDao;
import com.academia.mambostepapirest.services.IClaseDictadaService;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


@Component
public class ScheduledTask {
	
	@Autowired
	private IClaseDictadaService claseDictadaService;
	
	@Scheduled(cron = "${app.scheduled-task.clase-a-dictar.frequency}", zone = "America/Bogota")
	public void createClaseDictar() {
		//claseDictadaService.insertClaseADictar(DaysHomologation.DAY.get(Calendar.DAY_OF_WEEK), 
	    		//LocalTime.now().truncatedTo(ChronoUnit.HOURS).plusHours(1).toString());
	    		claseDictadaService.insertClaseADictar("Lunes","18:00");
	}
}
