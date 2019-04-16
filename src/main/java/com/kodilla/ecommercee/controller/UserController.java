package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {

//    @GetMapping(value = "getUsers")
//    public List<String> getUsers() {
//        return new ArrayList<>();
//    }
//
//    @GetMapping(value = "getUser")
//    public String getUserById(@RequestParam int userId) {
//        return "user";
//    }
//
//    @DeleteMapping(value = "deleteUser")
//    public void deleteById(@RequestParam int userId) {
//        System.out.println("User is deleted.");
//    }
//
//    @PostMapping(value = "createUser")
//    public void createUser(@RequestBody String user) {
//
//    }
//
//    @PutMapping(value = "generateKey")
//    public String authorizationUser(@RequestBody String key) {
//        return UUID.randomUUID().toString();
//    }
//
//    @PutMapping(value = "blockingUser")
//    public String blockingUser(@RequestBody String key) {
//        return "User is blocking";
//    }

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
