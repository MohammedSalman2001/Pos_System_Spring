package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    public String userName ;
    public String email;
    public String password;
    public String nicNo;
    public String contact;
    public String address;
    public String gender;

}
