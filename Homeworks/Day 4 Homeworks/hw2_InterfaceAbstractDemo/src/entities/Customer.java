package entities;
import java.util.Calendar;

import abstracts.Entity;

public class Customer implements Entity {
	public String firstName;
	public String lastName;
	public Calendar dateOfBirth;
	public String nationalityId;
	
	public Customer(String firstName, String lastName, Calendar dateOfBirth, String nationalityId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
	}
	
	
}
