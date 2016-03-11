package com.dechichi.spring.web.service;

import com.dechichi.spring.web.DAO.User;
import com.dechichi.spring.web.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gabriel on 10/03/16.
 */

@Service("usersService")
public class UsersService {

    private UserDAO usersDao;

    @Autowired
    public void setOffersDao(UserDAO usersDao) {
        this.usersDao = usersDao;
    }


    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exists(String username) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }
}