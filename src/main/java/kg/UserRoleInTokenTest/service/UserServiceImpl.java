package kg.UserRoleInTokenTest.service;

import kg.UserRoleInTokenTest.entity.User;
import kg.UserRoleInTokenTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * WORK WITH ODM
     */
    /*@Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }*/

    /**
     * WORK WITH ORM
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
