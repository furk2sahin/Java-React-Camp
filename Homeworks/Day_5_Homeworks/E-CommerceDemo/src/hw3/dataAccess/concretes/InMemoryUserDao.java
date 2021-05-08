package hw3.dataAccess.concretes;

import hw3.dataAccess.abstracts.UserDao;
import hw3.model.concretes.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryUserDao implements UserDao {

    private static List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void update(int userId, boolean active) {
       for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
           User user = iterator.next();
           if(user.getId() == userId){
               user.setActivated(active);
               System.out.println(user.getFirstName() + "'s account is now " + (active ? "active" : "passive"));
               return;
           }
       }
        System.out.println("Activation Code didn't match");
    }

    @Override
    public void delete(int userId) {
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
            User user = iterator.next();
            if(user.getId() == userId){
                iterator.remove();
                System.out.println(user.getEmail() + " deleted successfully.");
                return;
            }
        }
        System.out.println("Cannot find user with id: " + userId);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(int userId) {
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
            User user = iterator.next();
            if(user.getId() == userId)
                return user;
        }
        return null;
    }

    @Override
    public boolean emailExists(String email) {
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
            if(iterator.next().getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public User checkUserInformation(String email, String password) {
        for(Iterator<User> iterator = users.iterator(); iterator.hasNext();){
            User user = iterator.next();
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }
}
