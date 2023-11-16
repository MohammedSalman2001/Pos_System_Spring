package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.core.UserDto;
import lk.ijse.spring.dto.req.RequestUserDto;
import lk.ijse.spring.dto.res.ResponseUserDto;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.Generator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ModelMapper mapper;

    private final Generator  generator;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper, Generator generator) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.generator = generator;
    }

    public ResponseUserDto saveUser(RequestUserDto dto) {

        String userId = generator.generateKey("User");
        UserDto userDto = mapper.map(dto, UserDto.class);
        userDto.setUserId(userId);
        if(!userRepo.existsById(userDto.getEmail())) {
            User user = mapper.map(userDto, User.class);
            return mapper.map(userRepo.save(user), ResponseUserDto.class);
        }else {
            throw new RuntimeException("User "+ dto.getEmail() +" Already Exist");
        }
    }

    public void deleteByEmail(String email) {
        userRepo.deleteByEmail(email);
    }

    public void updateUser(RequestUserDto dto) {
        UserDto userDto = mapper.map(dto, UserDto.class);
        if(userRepo.existsById(userDto.getEmail())) {
            User user = mapper.map(userDto, User.class);
            userRepo.updateUser(user.getUserName(),
                    user.password,
                    user.nicNo,
                    user.gender,
                    user.contact,
                    user.address,
                    user.getEmail()
                    );
        }else {
            throw new RuntimeException("User "+ dto.getEmail() +" Already Exist");
        }

    }

    public ResponseUserDto searchUser(String email) {
        User byEmail = userRepo.findByEmail(email);
       return mapper.map(byEmail, ResponseUserDto.class);
    }

    public List<ResponseUserDto> getAllUser() {
        List<User> all = userRepo.findAll();
       return mapper.map(all,new TypeToken<List<RequestUserDto>>(){}.getType());
    }
}
