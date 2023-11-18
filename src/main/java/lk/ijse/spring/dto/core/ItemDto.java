package lk.ijse.spring.dto.core;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private String code;
    private String description;
    private int qtyOnHand;
    private double unitePrice;
}
