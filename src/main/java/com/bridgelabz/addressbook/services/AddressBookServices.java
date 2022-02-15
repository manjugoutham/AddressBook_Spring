package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServices implements IAddressBookServices {
    private List<AddressBookData> addressBoolList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBoolList;
    }
    @Override
//    public AddressBookData getAddressBookDataById(int personId) {
//        AddressBookData addressBookData = null;
//        addressBookData = new AddressBookData(1,new AddressBookDTO("Goutham","gouthu@gmail.com","8105457612","MG Road","Banglore","Karnataka","560050"));
//        return addressBookData;
//    }
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBoolList.stream()
                .filter(addressBookData -> addressBookData.getPersonId()==personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Person Not Found!!"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {

        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,addressBookDTO);
        addressBoolList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressData = this.getAddressBookDataById(personId);
        addressData.setName(addressBookDTO.getName());
        addressData.setEmailId(addressBookDTO.getEmailId());
        addressData.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressData.setAddress(addressBookDTO.getAddress());
        addressData.setCity(addressBookDTO.getCity());
        addressData.setState(addressBookDTO.getState());
        addressData.setZipCode(addressBookDTO.getZipCode());
        addressBoolList.set(personId-1,addressData);
        return addressData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressBoolList.remove(personId-1);
    }
}

