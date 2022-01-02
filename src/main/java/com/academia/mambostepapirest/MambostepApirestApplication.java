package com.academia.mambostepapirest;

import java.time.temporal.ChronoUnit;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.academia.mambostepapirest.utils.holiday.Holiday;
import com.academia.mambostepapirest.utils.holiday.HolidayUtil;

@SpringBootApplication
public class MambostepApirestApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MambostepApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(bcryptPasswordEncoder.encode("123456789"));
		System.out.println(LocalTime.now().truncatedTo(ChronoUnit.HOURS));
		
	}

}
