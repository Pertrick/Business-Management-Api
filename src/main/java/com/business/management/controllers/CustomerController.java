package com.business.management.controllers;

import com.business.management.dto.CustomerDTO;
import com.business.management.entity.Customer;
import com.business.management.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;
    public ResponseEntity<CustomerDTO> store(@Valid @RequestBody CustomerDTO customerDTO, , HttpServletRequest request){
        Long userId = (Long) request.getAttribute("userId");
        Customer customer = customerService.save(customerDTO, userId);

        CustomerDTO savedCustomerDTO =

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomerDTO);
    }
}
