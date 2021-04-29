import manager.InstructorManager;
import manager.StudentManager;
import manager.UserManager;
import model.Instructor;
import model.Student;
import model.User;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Furkan");
		student1.setSurname("Sahin");
		student1.setStudentNumber("123123");
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Sahin");
		student2.setSurname("Sahin");
		student2.setStudentNumber("11111");
		
		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Student");
		student3.setSurname("Three");
		student3.setStudentNumber("22223");
		
		Instructor instructor1 = new Instructor();
		instructor1.setId(1);
		instructor1.setName("Engin");
		instructor1.setSurname("Demirog");
		instructor1.setSalary(5000);
		
		Instructor instructor2 = new Instructor();
		instructor2.setId(2);
		instructor2.setName("Demirog");
		instructor2.setSurname("Engin");
		instructor2.setSalary(15000);
		
		Student[] students = {student1, student2, student3};
		Instructor[] instructors = {instructor1, instructor2};
		User[] users = {student1, student2, student3, instructor1, instructor2};
		
		StudentManager studentManager = new StudentManager();
		InstructorManager instructorManager = new InstructorManager();
		UserManager userManager = new UserManager();
		
		studentManager.getInformation(student1);
		studentManager.getStudentInformation(student2);
		studentManager.getStudentList(students);
		
		instructorManager.getInformation(instructor1);
		instructorManager.raiseSalary(instructor2);
		instructorManager.getInstructorInformation(instructor2);
		instructorManager.getInstructorList(instructors);
		
		userManager.getInformation(student1);
		userManager.getInformation(instructor1);
		userManager.getUserInformation(student1);
		userManager.getUserInformation(instructor1);
		userManager.getUserList(users);
		
	}
}
