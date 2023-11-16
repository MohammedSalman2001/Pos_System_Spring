package lk.ijse.spring.controller;


import lk.ijse.spring.dto.req.RequestUserDto;
import lk.ijse.spring.dto.res.ResponseUserDto;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@CrossOrigin
public class UserController {

        private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@ModelAttribute RequestUserDto dto){
        ResponseUserDto user = userService.saveUser(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",user), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody RequestUserDto dto){
       userService.updateUser(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"update",null), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"email"})
    public ResponseEntity<StandResponse> delete(@RequestParam String email){
        userService.deleteByEmail(email);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"delete",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "list")
    public ResponseEntity<StandResponse> getAll(){
        List<ResponseUserDto> user = userService.getAllUser();
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",user), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{searchId}")
    public ResponseEntity<StandResponse> get(@PathVariable("searchId") String id){
        ResponseUserDto user = userService.searchUser(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"searchId",user), HttpStatus.CREATED
        );

    }
}
