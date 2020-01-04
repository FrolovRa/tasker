package net.frolov.controller;

import net.frolov.entity.dto.UserCreateDto;
import net.frolov.entity.dto.UserReadDto;
import net.frolov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserReadDto getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserReadDto addUser(@RequestBody UserCreateDto user) {
        return userService.addUser(user);
    }
}
