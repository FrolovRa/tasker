package services;

import dao.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(long userId);
}
