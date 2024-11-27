package com.business.management.controllers.user;

import com.business.management.dto.LoginDTO;
import com.business.management.dto.UserDTO;
import com.business.management.entity.User;
import com.business.management.mapper.UserMapper;
import com.business.management.response.JwtAuthResponse;
import com.business.management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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

    @PostMapping("login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDTO){
        try{
            String token  = userService.login(loginDTO);
            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(token);
            return ResponseEntity.ok(jwtAuthResponse);
        }catch(BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtAuthResponse("Invalid Credentials",true));
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(new JwtAuthResponse("An error occurred",true));
        }

    }
}
