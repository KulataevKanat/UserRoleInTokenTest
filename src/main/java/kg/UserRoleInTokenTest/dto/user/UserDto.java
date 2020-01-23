package kg.UserRoleInTokenTest.dto.user;

import kg.UserRoleInTokenTest.entity.User;

import java.util.LinkedList;
import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public static List<UserDto> toList(List<User> list) {
        List<UserDto> result = new LinkedList<>();
        for (User user : list) {
            result.add(new UserDto(user));
        }
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
