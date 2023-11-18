package lk.ijse.spring.dto.core;

import lk.ijse.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDto {

    private  String oId;
    private String date;
    private Customer customer;
    private List<OrderDetailsDto> orderDetails;
}
