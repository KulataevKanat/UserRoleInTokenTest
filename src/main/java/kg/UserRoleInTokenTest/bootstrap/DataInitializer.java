package kg.UserRoleInTokenTest.bootstrap;

import kg.UserRoleInTokenTest.entity.Premise;
import kg.UserRoleInTokenTest.repository.PremiseRepository;
import kg.UserRoleInTokenTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    PremiseRepository premiseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        kg.UserRoleInTokenTest.entity.User user = new kg.UserRoleInTokenTest.entity.User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(Arrays.asList("ROLE_USER"));
        userRepository.save(user);

        kg.UserRoleInTokenTest.entity.User admin = new kg.UserRoleInTokenTest.entity.User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        userRepository.save(admin);

    }
}
