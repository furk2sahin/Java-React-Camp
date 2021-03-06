package manager;

import model.Instructor;
import model.User;

public class InstructorManager extends UserManager{
	
	public void getInstructorInformation(Instructor instructor) {
		System.out.println("ID: " + instructor.getId());
		System.out.println("Name: " + instructor.getName());
		System.out.println("Surname: " + instructor.getSurname());
		System.out.println("Salary: " + instructor.getSalary() + "\n");
	}
	
	public void getInstructorList(Instructor[] instructors) {
		for(Instructor instructor : instructors) 
			getInstructorInformation(instructor);
	}
	
	public void raiseSalary(Instructor instructor) {
		instructor.setSalary(instructor.getSalary() * 1.1);
	}
	
	@Override
	public void getInformation(User user) {
		System.out.println(user.getName() + " is an instructor");
	}
}
