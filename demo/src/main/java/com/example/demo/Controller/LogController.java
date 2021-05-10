package com.example.demo.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Date_Time.DateTime;
import com.example.demo.Model.LogModel;
import com.example.demo.Repository.customerRepository;

@RestController
public class LogController {
	
	@Autowired
	private customerRepository repository;
	
	@RequestMapping("/home")
	public String Home() {
		return "Hello World";
	}
	
	@GetMapping("/checkIn")
	public void store_checkIN(@RequestParam String name) {
		
		DateTime date_time = new DateTime();
		String date = date_time.date_time().split(" ")[0];
		String time = date_time.date_time().split(" ")[1];
		String id = name + time;
		
		LogModel logmodel = new LogModel();
		
		logmodel.setId(id);
		logmodel.setName(name);
		logmodel.setLogType("IN");
		logmodel.setDate(date);
		logmodel.setTime(time);
		
		repository.save(logmodel);
	}
	
	@GetMapping("/checkOut")
	public void store_checkOUT(@RequestParam String name) {
		
		DateTime date_time = new DateTime();
		String date = date_time.date_time().split(" ")[0];
		String time = date_time.date_time().split(" ")[1];
		String id = name + time;
		
		LogModel logmodel = new LogModel();
		
		logmodel.setId(id);
		logmodel.setName(name);
		logmodel.setLogType("OUT");
		logmodel.setDate(date);
		logmodel.setTime(time);
		
		repository.save(logmodel);
	}
	
	@GetMapping("/getLog")
	public List<LogModel> get_details(@RequestParam String date) {
		return repository.findByDate(date);
	}
	
	@GetMapping("/getAllLog")
	public List<LogModel> get_allDetails() {
		return repository.findAll();
	}
	
}
