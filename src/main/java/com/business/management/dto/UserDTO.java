package com.business.management.dto;

import com.business.management.validation.ValidUUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {
    private Long id;

    @NotNull(message = "First name is required")
    @Size(min=2, max=100, message = "First Name must be between 2 and 100 characters")
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min=2, max=100, message = "Last Name must be between 2 and 100 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min=6, max=100, message = "Password must be between at least 8 character")
    private String password;
}
