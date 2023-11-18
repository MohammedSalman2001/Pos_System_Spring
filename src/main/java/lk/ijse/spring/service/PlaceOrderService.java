package lk.ijse.spring.service;



import lk.ijse.spring.dto.core.OrderDto;

public interface PlaceOrderService {
    public OrderDto saveOrder(OrderDto dto);

}
