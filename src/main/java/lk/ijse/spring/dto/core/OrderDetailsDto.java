package lk.ijse.spring.dto.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDto {

    private  String oid;


    private String itemCode;

    private int qty;

    private double unitePrice;

}
