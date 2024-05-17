package com.scoutspace.Accommodation.service;

import com.scoutspace.Accommodation.exception.UserNotFoundException;
import com.scoutspace.Accommodation.model.User;
import com.scoutspace.Accommodation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with email: " + user.getEmail() + " already exists");
        }

        return userRepository.save(user);

    }

    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findUserByUserId(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }


    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByUserId(Long userId) {
        userRepository.deleteUserByUserId(userId);
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteUserByEmail(email);
    }


}
