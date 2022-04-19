package com.booster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booster.model.Account;
import com.booster.repository.AccountRepository;

@RestController
@Controller
public class HelloController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping("/")
	public List<Account> lista() {
		List<Account> conta = accountRepository.findAll();
		return conta;
	}
	
}
