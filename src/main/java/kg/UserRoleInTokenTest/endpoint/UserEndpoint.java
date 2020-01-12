package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.user.UserDto;
import kg.UserRoleInTokenTest.dto.user.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserEndpoint {
    ResponseEntity<?> signIn(AuthenticationRequest data);

    UserDto findById(Long id);

    List<UserDto> findAll();
}
