package com.business.management.service;

import com.business.management.dto.LoginDTO;
import com.business.management.dto.UserDTO;
import com.business.management.entity.Tenant;
import com.business.management.entity.User;
import com.business.management.exceptions.EntityNotFoundException;
import com.business.management.repository.TenantRepository;
import com.business.management.repository.UserRepository;
import com.business.management.response.JwtAuthResponse;
import com.business.management.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private TenantRepository tenantRepository;


    public User create(UserDTO userDTO){
        String hashedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(hashedPassword);
        user.setRoles(userDTO.getRoles);

        Set<Tenant> tenants = new HashSet<>();
        for (Long tenantId : tenantIds) {
            Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
            tenants.add(tenant);
        }

        user.setTenants(tenants);

        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User  with ID " + id + " not Found"));
    }

    public String  login(LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmail(),
                loginDTO.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }
}
