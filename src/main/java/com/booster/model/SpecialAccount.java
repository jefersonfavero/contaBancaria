package com.booster.model;

import javax.persistence.Entity;

import person.Client;

@Entity
public class SpecialAccount extends Account {

	private double limit;

	public SpecialAccount(Agency agency, Client client) {
		super(agency, client);
		this.limit = 500.00;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	@Override
	public void moneyWithdraw(double value, Account account) {
		if (this.balance + limit <= value) {
			this.balance -= value;
			System.out.println("\nSaque realizado com sucesso!\nO saldo da conta é de: R$ " + this.balance + "0");
			String message = "\nSaque de:\tR$ " + value + "0.\tSaldo atual:\tR$ " + this.balance + "0.";
			this.generateExtract(account, message);
		} else {
			System.err.println(
					"Operação não permitida!\nA quantia que deseja sacar é superior ao valor de seu saldo somado com o limite em sua conta!");
		}
	}
}
