package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getAdress(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.isBlocked(),
                userDto.getUuid(),
                userDto.getBeginValidityOfUuid(),
                userDto.getEndValidityOfUuid(),
                userDto.getCart(),
                userDto.getOrders()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getAdress(),
                user.getLogin(),
                user.getPassword(),
                user.isBlocked(),
                user.getUuid(),
                user.getBeginValidityOfUuid(),
                user.getEndValidityOfUuid(),
                user.getCart(),
                user.getOrders());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getFirstName(), t.getLastName(), t.getBirthDate(), t.getAdress(), t.getLogin(), t.getPassword(), t.isBlocked(), t.getUuid(), t.getBeginValidityOfUuid(), t.getEndValidityOfUuid(), t.getCart(), t.getOrders()))
                .collect(Collectors.toList());
    }
}