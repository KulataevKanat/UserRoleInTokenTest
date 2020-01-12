package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.user.UserDto;

import java.util.List;

public interface UserEndpoint {
    UserDto findById(Long id);

    List<UserDto> findAll();
}
