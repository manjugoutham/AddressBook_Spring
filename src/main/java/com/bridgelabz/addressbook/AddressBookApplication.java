package com.bridgelabz.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(AddressBookApplication.class, args);
//	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("Employee payroll App Started in {}", context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll App Database User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}