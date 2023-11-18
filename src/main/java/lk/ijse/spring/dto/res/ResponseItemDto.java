package lk.ijse.spring.dto.res;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseItemDto {
    private String description;
    private int qtyOnHand;
    private double unitePrice;
}
