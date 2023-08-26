package net.ellshadday.app.service.user;

import net.ellshadday.app.payload.userDto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
}
