package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto dto);
    public void deleteByEmail(String email);

    public UserDto updateUser(UserDto dto);

    public UserDto searchUser(String id);

    public List<UserDto> getAllUser();

}
