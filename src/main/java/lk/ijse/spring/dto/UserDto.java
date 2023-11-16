package lk.ijse.spring.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    public String userName ;
    public String email;
    public String password;
    public String nicNo;
    public String contact;
    public String address;
    public String gender;

}
