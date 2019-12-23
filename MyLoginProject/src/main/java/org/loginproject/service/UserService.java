package org.loginproject.service;

import org.loginproject.controller.UnableToSaveUserException;
import org.loginproject.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> returnAllUsers();

    boolean checkIfUserCanBeLoggedIn(User user);

    Optional<User> findUserByUsername(String username);

    void create(User user) throws UnableToSaveUserException;
}
