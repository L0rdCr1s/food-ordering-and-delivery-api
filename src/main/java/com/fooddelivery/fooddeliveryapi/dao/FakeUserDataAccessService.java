package com.fooddelivery.fooddeliveryapi.dao;

import com.fooddelivery.fooddeliveryapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("FakeDao")
public class FakeUserDataAccessService implements UserDao {
    /**Because connection to a real database is not implemented,
     * currently users are stored in the List collection, this should
     * explain data being reset during server restarting*/
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

    @Override
    public List<User> selectAllUsers() {
        return Database;
    }
}
