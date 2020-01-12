package kg.UserRoleInTokenTest.dto.user;

import kg.UserRoleInTokenTest.entity.User;

import java.util.LinkedList;
import java.util.List;

public class UserDto {
    private Long id;
    private String username;

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

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();


    }
}
