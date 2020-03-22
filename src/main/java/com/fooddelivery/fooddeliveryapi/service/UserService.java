package com.fooddelivery.fooddeliveryapi.service;

import com.fooddelivery.fooddeliveryapi.dao.UserDao;
import com.fooddelivery.fooddeliveryapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao UserDao;

    @Autowired
    public UserService(@Qualifier("FakeDao") UserDao userDao) {
        UserDao = userDao;
    }

    public int addUser(User user){
        return  UserDao.insertUser(user);
    }

    public List<User> getAllUsers(){
        return UserDao.selectAllUsers();
    }
}
