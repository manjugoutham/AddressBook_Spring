package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookReposiory;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServices implements IAddressBookServices {
    @Autowired
    private AddressBookReposiory addressBookReposiory;

    private ModelMapper mapper;

    private List<AddressBookData> addressBoolList = new ArrayList<>();
    public AddressBookServices(AddressBookReposiory addressBookReposiory,ModelMapper mapper){
        this.addressBookReposiory = addressBookReposiory;
        this.mapper = mapper;
    }
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookReposiory.findAll();
    }
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
        mapper.map(addressBookDTO,addressData);
        return addressBookReposiory.save(addressData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookReposiory.delete(addressBookData);
    }

    //ModelMapping..convert Entity to DTO
    private AddressBookDTO mapToDTO(AddressBookData addressBookData){
        AddressBookDTO addressBookDTO = mapper.map(addressBookData,AddressBookDTO.class);
        return addressBookDTO;
    }

    //convert DTO to entity
    private AddressBookData mapToEntity(AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = mapper.map(addressBookDTO,AddressBookData.class);
        return addressBookData;
    }

}

