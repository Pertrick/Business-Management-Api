package com.business.management.controllers.user;

import com.business.management.dto.UserDTO;
import com.business.management.entity.User;
import com.business.management.mapper.UserMapper;
import com.business.management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO){
        User user = userService.create(userDTO);
        UserDTO savedUserDTO = UserMapper.userToDTO(user);
        return ResponseEntity.ok(savedUserDTO);

    }
}
