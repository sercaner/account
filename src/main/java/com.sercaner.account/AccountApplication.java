package com.sercaner.account;

import com.sercaner.account.model.Customer;
import com.sercaner.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer = customerRepository.save(new Customer("Sercan", "Er"));
        System.out.println(customer);
	}

}
