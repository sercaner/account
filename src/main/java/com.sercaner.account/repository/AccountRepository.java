package com.sercaner.account.repository;

import com.sercaner.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>{
}
