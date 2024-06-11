package com.sercaner.account.service;

import com.sercaner.account.dto.CustomerDto;
import com.sercaner.account.dto.CustomerDtoConverter;
import com.sercaner.account.exception.CustomerNotFoundException;
import com.sercaner.account.model.Customer;
import com.sercaner.account.repository.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class CustomerServiceTest {

    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDtoConverter converter;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository, converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer  customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.of(customer));

        Customer result = service.findCustomerById("id");

        assertEquals(result, customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> service.findCustomerById("id"));
    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer() {
        Customer  customer = new Customer("id", "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(java.util.Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = service.getCustomerById("id");

        assertEquals(result, customerDto);
    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());


        assertThrows(CustomerNotFoundException.class,
                () -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }
}