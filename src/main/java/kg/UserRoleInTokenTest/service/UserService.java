package kg.UserRoleInTokenTest.service;

import kg.UserRoleInTokenTest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    User findById(Long id);

    List<User> findAll();

    Optional<User> findByUsername(String username);
}
