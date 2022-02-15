package com.bridgelabz.addressbook.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    @NotNull
    private String name;
    private String emailId;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;

}
