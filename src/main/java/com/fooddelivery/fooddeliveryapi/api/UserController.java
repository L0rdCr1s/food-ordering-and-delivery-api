package com.fooddelivery.fooddeliveryapi.api;

import com.fooddelivery.fooddeliveryapi.model.User;
import com.fooddelivery.fooddeliveryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return  userService.getUserById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }

    @PutMapping(path="{id}")
    public void updateUser(@PathVariable("id")UUID id, @RequestBody User user){
        userService.updateUser(id, user);
    }
}
