package net.frolov.service;

import net.frolov.entity.dto.UserReadDto;

public interface UserService {
    UserReadDto findById(long userId);

    UserReadDto addUser();
}
