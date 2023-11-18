package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Item {
    @Id
    private String code;
    private String description;
    private int qtyOnHand;
    private double unitePrice;


    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails;

}
