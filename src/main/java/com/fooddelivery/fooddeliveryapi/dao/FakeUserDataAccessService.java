package com.fooddelivery.fooddeliveryapi.dao;

import com.fooddelivery.fooddeliveryapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("FakeDao")
public class FakeUserDataAccessService implements UserDao {
    private static List<User> Database = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        Database.add(new User(
                id,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getProfileImage()
        ));
        return 1;
    }
}
