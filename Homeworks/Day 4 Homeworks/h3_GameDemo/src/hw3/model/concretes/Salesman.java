package hw3.model.concretes;

import java.util.Calendar;

import hw3.model.abstracts.Entity;

public class Salesman implements Entity{
	private int id;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Calendar birthDate;
	
	public Salesman(int id, String firstName, String lastName, String nationalIdentity, Calendar birthDate) {
		this.id = id;;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
}
