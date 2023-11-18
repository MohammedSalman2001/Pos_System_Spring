package lk.ijse.spring.dto.core;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class OrderDetailsDto {

    private  String oid;


    private String itemCode;

    private int qty;

    private double unitePrice;

}
