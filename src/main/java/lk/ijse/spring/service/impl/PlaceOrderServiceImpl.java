package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.core.OrderDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.PlaceOrderRepo;
import lk.ijse.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private  final PlaceOrderRepo placeOrderRepo;

    private final OrderDetailsRepo orderDetailsRepo;

    private final ItemRepo itemRepo;

    private final ModelMapper mapper;

    public PlaceOrderServiceImpl(PlaceOrderRepo placeOrderRepo, OrderDetailsRepo orderDetailsRepo, ItemRepo itemRepo, ModelMapper mapper) {
        this.placeOrderRepo = placeOrderRepo;
        this.orderDetailsRepo = orderDetailsRepo;
        this.itemRepo = itemRepo;
        this.mapper = mapper;
    }

    public OrderDto saveOrder(OrderDto dto) {

        if(!placeOrderRepo.existsById(dto.getOId())){

            Orders order = mapper.map(dto, Orders.class);

            for(OrderDetails orderDetails:order.getOrderDetails()) {
                Item checkQty = itemRepo.findById(orderDetails.getItemCode()).get();
                if (checkQty.getQtyOnHand() >= orderDetails.getQty()) {
                } else {
                    throw new RuntimeException("Item Qty Not found");
                }
            }
            placeOrderRepo.save(order);

            if (dto.getOrderDetails().size()<1)throw new RuntimeException("No item added");

            for(OrderDetails details:order.getOrderDetails()){
                Item item = itemRepo.findById(details.getItem().getCode()).get();
                item.setQtyOnHand(item.getQtyOnHand()-details.getQty());
                itemRepo.save(item);
            }

        }else {
            throw  new RuntimeException("Duplicate Id: "+ dto.getOId());
        }
        return null;
    }
}
