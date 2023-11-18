package lk.ijse.spring.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Orders> orders;

}
