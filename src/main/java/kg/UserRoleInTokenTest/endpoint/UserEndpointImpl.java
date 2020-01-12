package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.user.UserDto;
import kg.UserRoleInTokenTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEndpointImpl implements UserEndpoint {
    @Autowired
    private UserService userService;

    @Override
    public UserDto findById(Long id) {
        return new UserDto(userService.findById(id));
    }

    @Override
    public List<UserDto> findAll() {
        return UserDto.toList(userService.findAll());
    }
}
