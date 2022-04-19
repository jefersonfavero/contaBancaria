package person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.booster.model.Account;

import utils.Files;

@Entity
public abstract class Person {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	

	public Person() {
		//Random random = new Random();
		//this.id = random.nextInt(100);
	}

	public int getId() {
		return id;
	}

	public void consultExtract(Account account) {
		String divisor = "=============================================================";
		System.out.printf("\n%s\n\t\t\tExtrato bancário\n%s\n", divisor, divisor);
		String file = account.getNumber() + ".log";
		Files files = new Files();
		files.read(file);
		System.out.println(divisor);
	}

}
