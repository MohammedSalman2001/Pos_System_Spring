package lk.ijse.spring.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestUserDto {
    public String email;
    public String userName ;
    public String password;

    public String nicNo;
    public String contact;
    public String address;
    public String gender;
}
