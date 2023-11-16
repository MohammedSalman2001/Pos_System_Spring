package lk.ijse.spring.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StandResponse {
 private  int code;
 private String message;
 private Object data;
}
