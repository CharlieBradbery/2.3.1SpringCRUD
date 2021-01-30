package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public void add(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
}
