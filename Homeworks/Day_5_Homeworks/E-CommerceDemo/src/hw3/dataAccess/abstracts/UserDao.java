package hw3.dataAccess.abstracts;

import hw3.model.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(int userId, boolean active);
    void delete(int userId);
    List<User> getUsers();
    User getUser(int userId);
    boolean emailExists(String email);
    User checkUserInformation(String email, String password);
}
