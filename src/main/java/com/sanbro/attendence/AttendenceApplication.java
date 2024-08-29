package com.sanbro.attendence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AttendenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendenceApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(){
		return  "hello santosh!";
	}


}
