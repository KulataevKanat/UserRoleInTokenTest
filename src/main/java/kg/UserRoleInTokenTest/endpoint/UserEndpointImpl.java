package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.user.AuthenticationRequest;
import kg.UserRoleInTokenTest.dto.user.UserDto;
import kg.UserRoleInTokenTest.repository.UserRepository;
import kg.UserRoleInTokenTest.security.JwtTokenProvider;
import kg.UserRoleInTokenTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> signIn(AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            /**
             * WORK WITH ODM
             */
            /*String token = jwtTokenProvider.createToken(username, userService.findByUsername(username).get(0).getRoles());*/

            /**
             * WORK WITH ORM
             */
            String token = jwtTokenProvider.createToken(username,
                    userRepository.findByUsername(username).orElseThrow(() ->
                            new UsernameNotFoundException("Username " + username + "not found")).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @Override
    public UserDto findById(Long id) {
        return new UserDto(userService.findById(id));
    }

    @Override
    public List<UserDto> findAll() {
        return UserDto.toList(userService.findAll());
    }
}
