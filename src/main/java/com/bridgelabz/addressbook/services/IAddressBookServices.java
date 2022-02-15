package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface IAddressBookServices {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO);

    AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO);

    void deleteAddressBookData(int personId);
    Integer findAddressBookDataByCity(String city);
}
