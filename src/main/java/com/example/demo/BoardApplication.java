package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.mapper.DataMapper;

@SpringBootApplication
public class BoardApplication {

	@Autowired
	DataMapper dataMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
