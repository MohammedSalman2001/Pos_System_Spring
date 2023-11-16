package lk.ijse.spring.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseUserDto {
    public String userName ;
    public String email;
    public String password;

    public String nicNo;
    public String contact;
    public String address;
    public String gender;
}
