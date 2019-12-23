package org.loginproject.service;

import org.loginproject.controller.UnableToSaveUserException;
import org.loginproject.dto.User;
import org.loginproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> returnAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean checkIfUserCanBeLoggedIn(User user) {
        if( userRepository.findByUsername(user.getUsername()).isPresent() ) {
            User dbUser = (userRepository.findByUsername(user.getUsername())).get();
            return dbUser.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void create(User user) throws UnableToSaveUserException {
        if (checkIfUserFieldsAreNotEmpty(user) && userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(user.getPassword());
            userRepository.save(user);
        } else {
            throw new UnableToSaveUserException();
        }
    }

    private boolean checkIfUserFieldsAreNotEmpty(User user) {
        return user.getUsername() != null && user.getPassword() != null &&
                !user.getUsername().isBlank() && !user.getPassword().isBlank();
    }

}
