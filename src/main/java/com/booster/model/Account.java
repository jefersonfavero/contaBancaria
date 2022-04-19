package com.booster.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import person.Client;
import utils.Files;
@Entity
public abstract class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	protected double balance;
	private boolean status;
	private CreditCard creditCrad;
	private Agency agency;
	private Client client;
	
	

	public Account() {
		super();
	}

	public Account(Agency agency, Client client) {
		Random random = new Random();
		this.number = "";
		for (int i = 0; i < 7; i++) {
			this.number += random.nextInt(10);
		}
		this.number += "-" + random.nextInt(10);
		this.balance = 0;
		this.status = true;
		this.client = client;
		this.creditCrad = new CreditCard(this.client);
		this.agency = agency;
	}

	public String getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String getStatus() {
		return status ? "Ativada" : "Desativada";
	}

	public CreditCard getCreditCrad() {
		return creditCrad;
	}

	public Agency getAgency() {
		return agency;
	}

	public Client getClient() {
		return client;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void generateExtract(Account account, String textForFile) {
		String file = account.getNumber() + ".log";
		Files files = new Files();
		files.write(file, textForFile);
	}

	public void consultAccountData(Account account) {
		System.out.println(
				"Agência: " + account.getAgency().getAgencyNumber() + " - " + account.getAgency().getAgencyName());
		System.out.println("Numero da conta: " + account.getNumber());
		System.out.println("Status: " + account.getStatus());
		System.out.printf("Saldo: R$ %.2f\n", account.getBalance());
		System.out.println("Cartão de crédito da conta: " + account.getCreditCrad().getCardNumbering());
		System.out.println("Cliente: " + account.getClient().getName());
	}

	public void moneyDeposit(double value, Account account) {
		if (value <= 0) {
			System.err.println("Operação não permitida!\nO valor do deposito não pode ser negativo!");
		} else {
			this.balance += value;
			System.out.println("\nDeposito realizado com sucesso!\nSeu saldo é: R$ " + this.balance + "0");
			String message = "\nDepósito de:\tR$ " + value + "0.\tSaldo atual:\tR$ " + this.balance + "0.";
			generateExtract(account, message);
		}
	};

	public abstract void moneyWithdraw(double value, Account account);
}
