package net.frolov.service.impl;

import lombok.val;
import net.frolov.dao.UserDao;
import net.frolov.entity.User;
import net.frolov.entity.dto.UserCreateDto;
import net.frolov.entity.dto.UserReadDto;
import net.frolov.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import net.frolov.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserReadDto findById(long userId) {
        final val userOptional = userDao.findById(userId);
        final User user = userOptional.orElseThrow(() -> new EntityNotFoundException(User.class, userId));
        return toReadDto(user);
    }

    @Override
    public UserReadDto addUser(UserCreateDto userCreateDto) {
        final User user = new User();
        user.setDescription(userCreateDto.getDescription());
        user.setTasks(Collections.emptySet());
        User savedUser = userDao.saveUser(user);
        return toReadDto(savedUser);
    }

    private UserReadDto toReadDto(User user) {
        final val userReadDto = new UserReadDto();
        userReadDto.setId(user.getId());
        userReadDto.setDescription(user.getDescription());
        userReadDto.setTasks(user.getTasks());
        return userReadDto;
    }
}