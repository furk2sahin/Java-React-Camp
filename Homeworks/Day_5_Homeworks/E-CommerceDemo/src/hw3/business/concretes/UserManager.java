package hw3.business.concretes;

import hw3.business.abstracts.UserService;
import hw3.core.abstracts.AuthenticationService;
import hw3.dataAccess.abstracts.UserDao;
import hw3.model.concretes.User;

import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;
    private AuthenticationService authenticationService;

    public UserManager(UserDao userDao, AuthenticationService authenticationService){
        this.userDao = userDao;
        this.authenticationService = authenticationService;
    }

    @Override
    public void add(User user) {
        if(user.getFirstName().length() < 2){
            System.out.println("Your first name cannot be less then 2 characters.");
            return;
        }
        if(user.getLastName().length() < 2){
            System.out.println("Your last name cannot be less then 2 characters.");
            return;
        }
        if(user.getPassword().length() < 6){
            System.out.println("Your password cannot be less then 6 characters.");
            return;
        }
        if(authenticationService.register(user.getEmail())){
            System.out.println("Successfully Registered! Please note your activation code: " + user.getActivationCode());
            userDao.add(user);
        }

    }

    @Override
    public void update(int userId, String activationCode, String otherActivationCode) {
        if(authenticationService.activate(activationCode, otherActivationCode))
            userDao.update(userId, true);
        else
            userDao.update(userId, false);
    }

    @Override
    public void delete(int userId) {
        if(userId <= 0){
            System.out.println("User ID must be bigger than 0.");
            return;
        }
        userDao.delete(userId);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(int userId) {
        if(userId <= 0){
            System.out.println("User ID must be bigger than 0.");
            return null;
        }
        return userDao.getUser(userId);
    }

    @Override
    public boolean emailExists(String email) {
        return userDao.emailExists(email);
    }

    @Override
    public User checkUserInformation(String email, String password) {
        return userDao.checkUserInformation(email, password);
    }
}
