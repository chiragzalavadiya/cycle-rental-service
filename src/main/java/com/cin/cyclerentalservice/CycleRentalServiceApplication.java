package com.cin.cyclerentalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CycleRentalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycleRentalServiceApplication.class, args);
	}

}
