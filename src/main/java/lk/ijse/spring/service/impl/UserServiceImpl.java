package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.UserDto;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
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

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public UserDto saveUser(UserDto dto) {
        if(!userRepo.findByNicNo(dto.nicNo)){
            User user = mapper.map(dto, User.class);
           return mapper.map(userRepo.save(user),UserDto.class);
        }else {
            throw new RuntimeException("User "+ dto.getEmail() +"Already Exist");
        }

    }

    public void deleteByEmail(String email) {
        userRepo.deleteByEmail(email);
    }

    public UserDto updateUser(UserDto dto) {
      if(userRepo.findByNicNo(dto.nicNo)){
          User user = mapper.map(dto, User.class);
          return mapper.map(userRepo.save(user),UserDto.class);
      }else {
          throw new RuntimeException("User "+ dto.getEmail() +" Not Found");
      }
    }

    public UserDto searchUser(String email) {
        User byEmail = userRepo.findByEmail(email);
       return mapper.map(byEmail, UserDto.class);
    }

    public List<UserDto> getAllUser() {
        List<User> all = userRepo.findAll();
       return mapper.map(all,new TypeToken<List<UserDto>>(){}.getType());
    }
}
