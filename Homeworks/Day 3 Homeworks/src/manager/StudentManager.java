package manager;

import model.Student;
import model.User;

public class StudentManager extends UserManager{
	
	public void getStudentInformation(Student student) {
		System.out.println("ID: " + student.getId());
		System.out.println("Name: " + student.getName());
		System.out.println("Surname: " + student.getSurname());
		System.out.println("Salary: " + student.getStudentNumber() + "\n");
	}
	
	public void getStudentList(Student[] students) {
		for(Student student : students) 
			getStudentInformation(student);
	}
	
	@Override
	public void getInformation(User user) {
		System.out.println(user.getName() + " is a student \n");
	}
}
