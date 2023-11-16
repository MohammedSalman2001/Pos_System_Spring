package lk.ijse.spring.service;

import lk.ijse.spring.dto.req.RequestUserDto;
import lk.ijse.spring.dto.res.ResponseUserDto;

import java.util.List;

public interface UserService {
    public ResponseUserDto saveUser(RequestUserDto dto);
    public void deleteByEmail(String email);

    public void updateUser(RequestUserDto dto);

    public ResponseUserDto searchUser(String id);

    public List<ResponseUserDto> getAllUser();

}
