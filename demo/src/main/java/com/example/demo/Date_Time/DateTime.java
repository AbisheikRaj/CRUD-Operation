package com.example.demo.Date_Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	
	public String date_time() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String[] date_time = dtf.format(now).split(" ");
		String date = date_time[0];
		String time = date_time[1];
		return date + " " + time;
	}
}
