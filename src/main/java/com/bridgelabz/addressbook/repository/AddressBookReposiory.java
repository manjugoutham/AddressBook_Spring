package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookReposiory extends JpaRepository<AddressBookData,Integer> {
}
