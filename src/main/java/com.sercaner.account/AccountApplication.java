package com.sercaner.account;

import com.sercaner.account.model.Account;
import kotlin.collections.SetsKt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Account a = new Account("a", BigDecimal.ONE, LocalDateTime.now(), null, SetsKt.emptySet());
	}

}
