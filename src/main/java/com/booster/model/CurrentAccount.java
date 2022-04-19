package com.booster.model;

import javax.persistence.Entity;

import person.Client;

@Entity
public class CurrentAccount extends Account {

	
	
	public CurrentAccount(Agency agency, Client client) {
		super(agency, client);
	}

	@Override
	public void moneyWithdraw(double value, Account account) {
		if (this.balance > 0) {
			this.balance -= value;
			System.out.println("\nSaque realizado com sucesso!\nO saldo da conta é de: R$ " + this.balance + "0");
			String message = "\nSaque de:\tR$ " + value + "0.\tSaldo atual:\tR$ " + this.balance + "0.";
			this.generateExtract(account, message);
		} else {
			System.err.println("Operação não permitida!\nO saldo em sua conta é inferior a quantia que deseja sacar!");
		}
	}
}
