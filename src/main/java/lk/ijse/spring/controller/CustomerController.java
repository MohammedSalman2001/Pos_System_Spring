package lk.ijse.spring.controller;


import lk.ijse.spring.dto.core.CustomerDto;
import lk.ijse.spring.dto.req.RequestCustomerDto;
import lk.ijse.spring.dto.res.ResponseCustomerDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.StandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@ModelAttribute RequestCustomerDto dto){
      /*  System.out.println(dto.toString());
        System.out.println("save customer");*/
        ResponseCustomerDto customerDto = customerService.saveCustomer(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",customerDto), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody RequestCustomerDto dto){
        ResponseCustomerDto customerDto = customerService.updateCustomer(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",customerDto), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandResponse> delete(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "list")
    public ResponseEntity<StandResponse> getAll(){
        List<ResponseCustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",allCustomer), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{searchId}")
    public ResponseEntity<StandResponse> get(@PathVariable("searchId") String id){
        ResponseCustomerDto customerDto = customerService.searchCustomer(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"searchId",customerDto), HttpStatus.CREATED
        );

    }
}
