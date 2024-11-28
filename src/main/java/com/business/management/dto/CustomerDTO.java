package com.business.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private long id;

    @NotNull(message ="first name is required")
    @Size(min=2,max = 100, message = "First Name must be between 2 and 100 characters")
    private String firstName;

    @NotNull(message = "last name is required")
    @Size(min=2,max = 100, message = "Last Name must be between 2 and 100 characters")
    private String lastName;

    @NotNull(message = "email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be exactly 11 digits")
    private String phone;

    private AddressDTO addressDTO;

    @NotNull(message = "User ID is required")
    private Long userId;


}
