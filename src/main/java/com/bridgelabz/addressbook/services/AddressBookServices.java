package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookReposiory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServices implements IAddressBookServices {
    @Autowired
    private AddressBookReposiory addressBookReposiory;

    //private List<AddressBookData> addressBoolList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {

        return addressBookReposiory.findAll();
    }
//    public AddressBookData getAddressBookDataById(int personId) {
//        AddressBookData addressBookData = null;
//        addressBookData = new AddressBookData(1,new AddressBookDTO("Goutham","gouthu@gmail.com","8105457612","MG Road","Banglore","Karnataka","560050"));
//        return addressBookData;
//    }
    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookReposiory
                .findById(personId)
                .orElseThrow(() -> new AddressBookException("Person Not Found!!"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {

        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("Addres Data: "+addressBookData.toString());
       // addressBoolList.add(addressBookData);
        return addressBookReposiory.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressData = this.getAddressBookDataById(personId);
//        addressData.setName(addressBookDTO.getName());
//        addressData.setEmailId(addressBookDTO.getEmailId());
//        addressData.setPhoneNumber(addressBookDTO.getPhoneNumber());
//        addressData.setAddress(addressBookDTO.getAddress());
//        addressData.setCity(addressBookDTO.getCity());
//        addressData.setState(addressBookDTO.getState());
//        addressData.setZipCode(addressBookDTO.getZipCode());
//        addressBoolList.set(personId-1,addressData);
        addressData.updateAddressBookData(addressBookDTO);
        return addressBookReposiory.save(addressData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookReposiory.delete(addressBookData);
    }
}

