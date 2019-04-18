package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserDbService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(final Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        user.setUuid(null);
        user.setBeginValidityOfUuid(null);
        user.setEndValidityOfUuid(null);
        user.setBlocked(true);
        return repository.save(user);
    }

    public User generateKey(final User user, String lastName, String password) {
        if (user.getLastName().equals(lastName) && user.getPassword().equals(password)) {
            user.setUuid(UUID.randomUUID().toString());
            user.setBeginValidityOfUuid(LocalTime.now());
            user.setEndValidityOfUuid(user.getBeginValidityOfUuid().plusHours(1));
            user.setBlocked(true);
        }
        return repository.save(user);
    }

    public User unblockingUser(final User user) {
        long duration = Duration.between(LocalTime.now(), user.getEndValidityOfUuid()).toHours();
        if (duration >= 1)
            user.setBlocked(true);
        else
            user.setBlocked(false);
        return repository.save(user);
    }
}