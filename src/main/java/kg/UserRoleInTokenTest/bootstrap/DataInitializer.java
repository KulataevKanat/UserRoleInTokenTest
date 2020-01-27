package kg.UserRoleInTokenTest.bootstrap;

import kg.UserRoleInTokenTest.entity.User;
import kg.UserRoleInTokenTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(Collections.singletonList("ROLE_USER"));
        userRepository.save(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRoles(Collections.singletonList("ROLE_ADMIN"));
        userRepository.save(admin);

        User superAdmin = new User();
        superAdmin.setUsername("superAdmin");
        superAdmin.setPassword(passwordEncoder.encode("password"));
        superAdmin.setRoles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        userRepository.save(superAdmin);
    }
}
