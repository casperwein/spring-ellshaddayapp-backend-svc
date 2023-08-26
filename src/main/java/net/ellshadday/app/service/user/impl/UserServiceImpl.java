package net.ellshadday.app.service.user.impl;

import net.ellshadday.app.entity.user.User;
import net.ellshadday.app.payload.userDto.UserDTO;
import net.ellshadday.app.repository.user.UserRepository;
import net.ellshadday.app.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        User newUser = userRepository.save(user);
        UserDTO userRes = mapToDTO(newUser);
        return userRes;
    }


    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFull_name(user.getFull_name());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setGambar(user.getGambar());
        userDTO.setRole(user.getRole());
        userDTO.setPhone_number(user.getPhone_number());
        return userDTO;
    }

    private User mapToEntity(UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setFull_name(userDTO.getFull_name());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setGambar(userDTO.getGambar());
        user.setRole(userDTO.getRole());
        user.setPhone_number(userDTO.getPhone_number());
        return user;
    }
}
