package main;

import java.util.Scanner;

import com.booster.model.Agency;
import com.booster.model.CurrentAccount;

import person.Client;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Agency agency = new Agency("Booster Bank");
		Client client = new Client("Leonardo", "Rua do devs, nº 10");

		CurrentAccount currentAccount = new CurrentAccount(agency, client);
		currentAccount.consultAccountData(currentAccount);

		currentAccount.moneyDeposit(500.00, currentAccount);
		currentAccount.moneyDeposit(500.00, currentAccount);
		currentAccount.moneyDeposit(500.00, currentAccount);

		currentAccount.moneyWithdraw(500.00, currentAccount);
		currentAccount.moneyWithdraw(500.00, currentAccount);

		client.consultExtract(currentAccount);
		scanner.close();
	}

}
