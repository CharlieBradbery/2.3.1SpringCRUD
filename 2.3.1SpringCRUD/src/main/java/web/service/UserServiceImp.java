package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.dao.UserDao;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userdao;


    @Override
    public List<User> listUsers() {
        return userdao.listUsers();
    }

    @Override
    public void add(User user) {
        userdao.add(user);
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userdao.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userdao.getUserById(id);
    }


}
