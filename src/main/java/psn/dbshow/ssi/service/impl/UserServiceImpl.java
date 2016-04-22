package psn.dbshow.ssi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psn.dbshow.ssi.dao.UserDAO;
import psn.dbshow.ssi.povo.po.User;
import psn.dbshow.ssi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean register(User user) {
        return userDAO.insertUser(user) == 1;
    }

    public User login(String username, String password) {
        User user = userDAO.findByName(username);
        return (user.getPassword().equals(password)) ? user : null;
    }

}
