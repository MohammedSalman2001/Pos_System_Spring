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
public class OrderDto {

    private  String oId;
    private String date;
    private Customer customer;
    private List<OrderDetailsDto> orderDetailsDto;

    public OrderDto(String oId, String date, Customer customer) {
        this.oId = oId;
        this.date = date;
        this.customer = customer;
    }
}
