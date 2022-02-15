package com.bridgelabz.addressbook.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Person name is Invalid")
    private String name;

    @Pattern(regexp = "[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@gmail\\.com", message = "Person gmail is Invalid")
    private String emailId;
    @NotBlank(message = "PhoneNumber cannot be Empty")
    private String phoneNumber;

    @NotBlank(message = "address cannot be Empty")
    private String address;
    @NotBlank(message = "city cannot be Empty")
    private String city;
    @NotBlank(message = "state cannot be Empty")
    private String state;
    @NotBlank(message = "zipCode cannot be Empty")
    private String zipCode;

}
