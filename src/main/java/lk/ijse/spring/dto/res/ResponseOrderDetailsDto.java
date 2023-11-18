package lk.ijse.spring.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDto {

    private String name;
    private String address;
    private double salary;

//order
    private  String oId;
    private String date;
}
