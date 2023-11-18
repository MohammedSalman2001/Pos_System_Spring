package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_Id")
    private Orders orders;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_code")
    private Item item;

    private int qtyOnHand;

    private double total;

}
