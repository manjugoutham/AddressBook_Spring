package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Addressbook_datadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")

    private int personId;
    private String name;
    private String emailId;
    @Column(unique = true)
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO){
       // this.personId=personId;
        this.name=addressBookDTO.getName();
        this.emailId=addressBookDTO.getEmailId();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zipCode=addressBookDTO.getZipCode();
    }

}
