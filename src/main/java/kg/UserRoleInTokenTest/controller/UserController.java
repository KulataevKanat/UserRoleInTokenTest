package kg.UserRoleInTokenTest.controller;

import kg.UserRoleInTokenTest.dto.user.UserDto;
import kg.UserRoleInTokenTest.endpoint.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserEndpoint userEndpoint;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findById(@PathVariable Long id) {
        return userEndpoint.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAll() {
        return userEndpoint.findAll();
    }
}
