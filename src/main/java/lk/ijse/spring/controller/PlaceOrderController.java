package lk.ijse.spring.controller;


import lk.ijse.spring.dto.core.OrderDto;
import lk.ijse.spring.dto.res.ResponseOrderDetailsDto;
import lk.ijse.spring.service.PlaceOrderService;
import lk.ijse.spring.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
         placeOrderService.saveOrder(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",null), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody OrderDto dto){
        System.out.println(dto.toString());
        placeOrderService.updateOrder(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"update Order",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<StandResponse> find(@PathVariable String id){
        OrderDto orderDto = placeOrderService.find(id);
        System.out.println(orderDto.toString());
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",orderDto), HttpStatus.CREATED
        );
    }

    @GetMapping()
    public ResponseEntity<StandResponse> findAll(){
        List<OrderDto> all = placeOrderService.findAll();
        System.out.println(all);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",all), HttpStatus.CREATED
        );
    }

    @GetMapping("get-order-details")
    public ResponseEntity<StandResponse> getAllOrderDetails(){

      List<ResponseOrderDetailsDto> allOrdersDetails = placeOrderService.getAllOrdersDetails();

        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",allOrdersDetails ), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandResponse> delete(@RequestParam String id){
        placeOrderService.delete(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"save Order",null ), HttpStatus.CREATED
        );
    }

}
