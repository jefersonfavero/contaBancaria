package person;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client extends Person {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cpf;
	private String address;
	private String name;
	
	

	public Client() {
		super();
	}

	public Client(String name, String address) {
		Random random = new Random();
		this.id = random.nextInt(100);
		for (int i = 0; i < 11; i++) {
			this.cpf += random.nextInt(10);
		}
		this.address = address;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
