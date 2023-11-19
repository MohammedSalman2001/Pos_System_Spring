package lk.ijse.spring.service;



import lk.ijse.spring.dto.core.OrderDto;
import lk.ijse.spring.dto.res.ResponseOrderDetailsDto;
import lk.ijse.spring.entity.Orders;

import java.util.List;

public interface PlaceOrderService {
    public OrderDto saveOrder(OrderDto dto);
    public void updateOrder(OrderDto dto);

    public OrderDto find(String id);

    public List<OrderDto> findAll();

   public List<ResponseOrderDetailsDto> getAllOrdersDetails();

   public void delete(String id);

}
