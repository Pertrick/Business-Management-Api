package com.business.management.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private  Long id;

    @NotNull(message = "Street is required")
    @Size(min = 5, max = 255, message = "Street must be between 5 and 255 characters")
    private String Street;

    private String zipcode;

    @NotNull(message = "State is required")
    @Size(min = 2, max = 100, message = "State must be between 2 and 100 characters")
    private  String state;

    @NotNull(message = "City is required")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    private String city;

}
