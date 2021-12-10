package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.Objects;
import java.util.List;
import java.util.Set;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

<<<<<<< HEAD
    int create(String username, String password, String role, boolean isDoctor);
=======
    int create(String username, String password, String role);
>>>>>>> cb646d27976c522ebd759ebff9bc2d5c1fcd1a9e
}
