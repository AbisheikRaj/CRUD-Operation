package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.LogModel;

public interface customerRepository extends JpaRepository<LogModel, String> {
	
	List<LogModel> findByDate(String date);
}
