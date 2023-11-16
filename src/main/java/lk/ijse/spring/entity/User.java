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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    public String userName ;

    @Column(unique = true)
    public String email;
    public String password;

    @Column(unique = true)
    public String nicNo;
    public String contact;
    public String address;
    public String gender;

}
