package com.booster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booster.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
