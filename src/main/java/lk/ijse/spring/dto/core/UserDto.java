package lk.ijse.spring.dto.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    public String userId;
    public String userName ;


    public String email;
    public String password;

    public String nicNo;
    public String contact;
    public String address;
    public String gender;
}
