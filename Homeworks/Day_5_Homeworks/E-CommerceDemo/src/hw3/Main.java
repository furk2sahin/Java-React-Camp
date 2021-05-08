package hw3;

import hw3.business.abstracts.UserService;
import hw3.business.concretes.UserManager;
import hw3.core.concretes.GoogleAuthenticationManagerAdapter;
import hw3.dataAccess.concretes.InMemoryUserDao;
import hw3.model.concretes.User;
import hw3.util.CodeGenerator;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static final String REGISTER = "1";
    public static final String LOGIN = "2";
    public static final String DELETE_ACCOUNT = "3";
    public static final String EXIT = "Q";

    public static void main(String[] args) {
        String choise;
        int id = 1;
        Scanner scanner = new Scanner(System.in);
        UserService userManager = new UserManager(new InMemoryUserDao(), new GoogleAuthenticationManagerAdapter());
        User user;
        String firstName, lastName, email, password, activationCode;

        do {
            System.out.print("\n--------------------------\n" +
                    "Please choose an option\n" +
                    "1. Register\n" +
                    "2. Login\n" +
                    "q for exit\n" +
                    "Your choise: ");
            choise = scanner.nextLine();
            switch (choise) {
                case REGISTER:
                    System.out.print("Please enter your first name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Please enter your last name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();
                    if(userManager.emailExists(email)){
                        System.out.println("This email already taken.");
                    } else{
                        user = new User(id, firstName, lastName, email, password, CodeGenerator.generateCode(25), false);
                        userManager.add(user);
                    }
                    break;
                case LOGIN:
                    System.out.print("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();
                    user = userManager.checkUserInformation(email, password);
                    if (user == null) {
                        System.out.println("Wrong email or password.");
                    } else{
                        if(!user.isActivated()){
                            System.out.print("Please enter your activation code to activate your account:");
                            activationCode = scanner.nextLine();
                            userManager.update(user.getId(), user.getActivationCode(), activationCode);
                            if(user.isActivated()){
                                System.out.println("----------------------\n" +
                                        "Welcome!\n" +
                                        "First name: " + user.getFirstName() + "\n" +
                                        "Last name: " + user.getLastName() + "\n" +
                                        "Email: " + user.getEmail());
                                System.out.println("----------------------");
                                System.out.println("What do you want to do? \n" +
                                        "3. Delete my account\n" +
                                        "q for exit\n" +
                                        "Your choise: ");
                                choise = scanner.nextLine();
                                if(choise.equals(DELETE_ACCOUNT)){
                                    userManager.delete(user.getId());
                                }
                            }
                        }
                    }
                        break;
                default:
                    break;
            }
        } while (!choise.toUpperCase().equals(EXIT));
    }
}
