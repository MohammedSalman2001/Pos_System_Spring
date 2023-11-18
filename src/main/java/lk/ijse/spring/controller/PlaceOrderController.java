package lk.ijse.spring.controller;


import lk.ijse.spring.dto.core.OrderDto;
import lk.ijse.spring.service.PlaceOrderService;
import lk.ijse.spring.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/place-order")
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> saveOrder(@RequestBody OrderDto dto){
        System.out.println(dto.toString());
        OrderDto orderDto = placeOrderService.saveOrder(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",orderDto), HttpStatus.CREATED
        );
    }
}
