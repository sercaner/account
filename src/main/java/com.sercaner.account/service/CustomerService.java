package com.sercaner.account.service;

import com.sercaner.account.dto.AccountDto;
import com.sercaner.account.dto.CreateAccountRequest;
import com.sercaner.account.dto.CustomerDto;
import com.sercaner.account.dto.CustomerDtoConverter;
import com.sercaner.account.exception.CustomerNotFoundException;
import com.sercaner.account.model.Customer;
import com.sercaner.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                    () -> new CustomerNotFoundException("Customer could not find bu id: " + id));
    }


    public CustomerDto getCustomerById(String customerId) {
            return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}

