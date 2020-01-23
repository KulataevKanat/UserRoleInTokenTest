package kg.UserRoleInTokenTest.service;

import kg.UserRoleInTokenTest.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    /**
     * WORK WITH ODM
     */
//    List<User> findByUsername(String username);

    /**
     * WORK WITH ORM
     */
    Optional<User> findByUsername(String username);
}
