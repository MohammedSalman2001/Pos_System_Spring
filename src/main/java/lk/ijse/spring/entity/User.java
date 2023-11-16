package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class User {
    @Id
    public String email;
    @Column(unique = true)
    public String nicNo;
    @Column(unique = true)
    public String userId;
    public String userName;
    public String password;
    public String contact;
    public String address;
    public String gender;

}
