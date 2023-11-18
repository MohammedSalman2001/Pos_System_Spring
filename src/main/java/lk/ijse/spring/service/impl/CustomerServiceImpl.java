package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.core.CustomerDto;
import lk.ijse.spring.dto.req.RequestCustomerDto;
import lk.ijse.spring.dto.res.ResponseCustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.Generator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepo customerRepo;

    private final ModelMapper mapper;

    private final Generator generator;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper, Generator generator) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
        this.generator = generator;
    }


    public ResponseCustomerDto saveCustomer(RequestCustomerDto requestCustomerDto) {
        CustomerDto dto = mapper.map(requestCustomerDto, CustomerDto.class);
        if (!customerRepo.existsById(dto.getId())) {
            Customer customer = mapper.map(dto, Customer.class);
            return mapper.map(customerRepo.save(customer), ResponseCustomerDto.class);
        }else {
            throw new RuntimeException("customer" + dto.getId()+ " Already Exist..!");
        }
    }

    public void deleteCustomer(String id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);

        }else {
            throw new RuntimeException("customer" + id+ " Not found..!");
        }
    }

    public ResponseCustomerDto updateCustomer(RequestCustomerDto requestCustomerDto) {
        CustomerDto customerDto= mapper.map(requestCustomerDto, CustomerDto.class);
        if (customerRepo.existsById(customerDto.getId())) {
            Customer customer = mapper.map(customerDto, Customer.class);
            return mapper.map(customerRepo.save(customer), ResponseCustomerDto.class);
        }else {
            throw new RuntimeException("customer" + customerDto.getId()+ " Not found..!");
        }
    }



    public ResponseCustomerDto searchCustomer(String id) {
        if(customerRepo.existsById(id)) {
            Customer customer = customerRepo.findById(id).get();
            return mapper.map(customer, ResponseCustomerDto.class);
        }else {
            throw new RuntimeException("customer" + id+ " Not found..!");
        }

    }

    public List<ResponseCustomerDto> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
       return mapper.map(all, new TypeToken<List<ResponseCustomerDto>>() {}.getType());
    }
}
