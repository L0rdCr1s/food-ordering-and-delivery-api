package com.fooddelivery.fooddeliveryapi.dao;

import com.fooddelivery.fooddeliveryapi.model.User;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<User> selectUserById(UUID id) {
        return Database.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUser(UUID id) {
        /**Check if user exists in our database and delete them,
         * otherwise return 0 as user not found status */
        Optional<User> user = selectUserById(id);
        if(user.isEmpty()){
            return  0;
        }
        Database.remove(user.get());
        return 1;
    }

    @Override
    public int updateUser(UUID id, User user) {
        return selectUserById(id).map(prevUser -> {
           int indexOfUser = Database.indexOf(prevUser);
           if(indexOfUser >= 0){
               Database.set(indexOfUser, new User(
                       id,
                       user.getFirstName(),
                       user.getLastName(),
                       user.getEmail(),
                       user.getPassword(),
                       user.getProfileImage()
               ));
               return 1;
           }
           return 0;
        }).orElse(0);
    }
}
