package lk.ijse.spring.service;



import lk.ijse.spring.dto.core.CustomerDto;
import lk.ijse.spring.dto.req.RequestCustomerDto;
import lk.ijse.spring.dto.res.ResponseCustomerDto;

import java.util.List;

public interface CustomerService {

    public ResponseCustomerDto saveCustomer(RequestCustomerDto customer);
    public void deleteCustomer(String id);

    public ResponseCustomerDto updateCustomer(RequestCustomerDto customer);

    public ResponseCustomerDto searchCustomer(String id);

    public List<ResponseCustomerDto> getAllCustomer();
}
