package hw3.core;

import java.util.Calendar;

public interface PersonCheckService {
	public boolean checkIfRealPerson(String firstName, 
			String lastName, 
			String nationalIdentity,
			Calendar birthDate);
	
}
