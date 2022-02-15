package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookData {
    @Id
    private long personId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public AddressBookData(long personId, AddressBookDTO addressBookDTO){
        this.personId=personId;
        this.name=addressBookDTO.getName();
        this.emailId=addressBookDTO.getEmailId();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zipCode=addressBookDTO.getZipCode();
    }

}
