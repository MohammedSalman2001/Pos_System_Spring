package lk.ijse.spring.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Orders {

    @Id
    private  String oid;
    private String date;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customerId",referencedColumnName = "id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;


}
