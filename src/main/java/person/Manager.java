package person;

import java.util.Scanner;

import javax.persistence.Entity;

import com.booster.model.Account;

@Entity
public class Manager extends Person {
	public void updateAccountData(Account account) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("O que gostaria de alterar?\n1 - nome do cliente cadastrado\n2 - endereço");
		String response = scanner.nextLine();
		switch (response) {
		case "1":
			System.out.println("Digite o nome do cliente para atualizarmos:");
			response = scanner.nextLine();
			account.getClient().setName(response);
			System.out.println("O nome do cliente foi atualizado com sucesso!");
			break;
		case "2":
			System.out.println("Digite o endereço do cliente para atualizarmos:");
			response = scanner.nextLine();
			account.getClient().setAddress(response);
			System.out.println("O nome do cliente foi atualizado com sucesso!");
			break;
		default:
			System.out.println("Operação incorreta!\nDigite uma opção válida!");
			break;
		}
		scanner.close();
	}

	public void deleteAccount(Account account) {
		account.setStatus(false);
		System.out.println("Conta encerrada com sucesso!");
	}
}
