package com.fooddelivery.fooddeliveryapi.dao;

import com.fooddelivery.fooddeliveryapi.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);

    default int insertUser(User user){
        /**Auto-generate user id whenever new user is created */
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();
    Optional<User> selectUserById(UUID id);
    int deleteUser(UUID id);
}
