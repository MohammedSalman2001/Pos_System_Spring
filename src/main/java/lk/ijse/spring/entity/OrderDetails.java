package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@IdClass(OrderItem_PK.class)
public class OrderDetails {

    @Id
    private  String oid;

    @Id
    private String itemCode;

    private int qty;

    private double unitePrice;

    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private  Orders orders;


    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",insertable = false,updatable = false)
    private Item item;
}
