package lk.ijse.spring.dto.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.NamedEntityGraph;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerDto {

    private String id;
    private String name;
    private String address;
    private double salary;



}
