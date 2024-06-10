package com.sercaner.account.service;

import com.sercaner.account.dto.AccountDto;
import com.sercaner.account.dto.CreateAccountRequest;
import com.sercaner.account.exception.CustomerNotFoundException;
import com.sercaner.account.model.Customer;
import com.sercaner.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                    () -> new CustomerNotFoundException("Customer could not find bu id: " + id));
    }


}

