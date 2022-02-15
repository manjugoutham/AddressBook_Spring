package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
//	public static void main(String[] args) {
//		SpringApplication.run(AddressBookApplication.class, args);
//	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("Employee payroll App Started in {}", context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll App Database User is {}", context.getEnvironment().getProperty("spring.datasource.username"));

			AddressBookDTO addressbookdto = new AddressBookDTO();
			addressbookdto.setName("Arun");
			addressbookdto.setEmailId("aru12@gmail,com");
			addressbookdto.setPhoneNumber("9876543211");
			addressbookdto.setAddress("Kolar");
			addressbookdto.setCity("Banglore");
			addressbookdto.setState("delhi");
			addressbookdto.setZipCode("565655");
			AddressBookData addressbookdata = new AddressBookData();
			BeanUtils.copyProperties(addressbookdto, addressbookdata);
			System.out.println(addressbookdata);
		}

}
