package com.business.management.mapper;

import com.business.management.dto.CustomerDTO;
import com.business.management.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer DtoToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setStreet(customerDTO.getStreet());
        customer.setZipcode(customerDTO.getZipcod());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());

        return  customer;
    }
}
