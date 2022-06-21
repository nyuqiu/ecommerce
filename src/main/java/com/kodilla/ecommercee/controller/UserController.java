package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserDbService service;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DbUserService service;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers()
    {
        return userMapper.mapToUserDtoList(service.getAllUsers());
    }

    @GetMapping(value="getUser")
    public UserDto getUser(@RequestParam Long id)
    {
        return userMapper.mapToUserDto(service.getUserById(id));
    }

    @PostMapping(value="createUser")
    public void createUser(@RequestBody UserDto userDto)
    {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(value="generateKey")
    public UserDto generateKey(@RequestBody UserDto userDto, @RequestParam String lastName, @RequestParam String password)
    {
        return userMapper.mapToUserDto(service.generateKey(userMapper.mapToUser(userDto),lastName, password));

    }

    @PutMapping(value="unblockingUser")
    public UserDto unblockingUser(@RequestBody UserDto userDto)
    {
        return userMapper.mapToUserDto(service.unblockingUser(userMapper.mapToUser(userDto)));
    }
}