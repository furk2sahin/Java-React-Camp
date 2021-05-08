package hw3.business.abstracts;

import hw3.model.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(int userId, String activationCode, String otherActivationCode);
    void delete(int userId);
    List<User> getUsers();
    User getUser(int userId);
    boolean emailExists(String email);
    User checkUserInformation(String email, String password);
}
