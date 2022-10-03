package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.User;
import com.stefanini.pizzariabackend.repo.UserRepository;
import com.stefanini.pizzariabackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
