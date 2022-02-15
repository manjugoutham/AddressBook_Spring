package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.services.AddressBookServices;
import com.bridgelabz.addressbook.services.IAddressBookServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    IAddressBookServices addressBookServices;

    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData()
    {
        //List addressBookDataList = addressBookServices.getAddressBookData();
        List<AddressBookData> addreslist = null;
        addreslist = addressBookServices.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", addreslist);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId)
    {
        AddressBookData addressBookData = addressBookServices.getAddressBookDataById(personId);
        ResponseDTO respDTO = new ResponseDTO("Get Call By Id Success", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createaddAddressBookData(
            @Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookServices.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Address book data created", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
                                                            @Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookServices.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("updated adressBook data", addressBookDTO);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId)
    {
        addressBookServices.deleteAddressBookData(personId);
        ResponseDTO respDTO = new ResponseDTO("deleted sucessful ", "Deleted Id" + personId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }
    
}
