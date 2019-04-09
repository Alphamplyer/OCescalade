package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.UserDAO;
import com.alphamplyer.ocescalade.model.Login;
import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.UserService;
import com.alphamplyer.ocescalade.utils.password.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void register(User user) {
        String salt = Password.getSalt(30);
        user.setSalt(salt);
        user.setPassword(Password.generateSecurePassword(user.getPassword(), salt));
        this.userDAO.registerUser(user);
    }

    @Override
    @Transactional
    public User checkPassword(Login login) {
        User user = this.userDAO.getUserByNickname(login.getUsername());

        if (user == null)
            return null;

        String salt = user.getSalt();

        if (Password.verifyUserPassword(login.getPassword(), user.getPassword(), salt))
            return user;
        else
            return null;
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return this.userDAO.getUser(id);
    }
}
