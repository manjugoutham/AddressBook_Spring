package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressBookReposiory extends JpaRepository<AddressBookData,Integer> {


    @Query(value = "select count(*) from addressbook_datadb where city = :city", nativeQuery = true)
    Integer findAddressBookDataByCity(String city);

}
