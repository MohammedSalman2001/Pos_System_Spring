package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.core.OrderDetailsDto;
import lk.ijse.spring.dto.core.OrderDto;
import lk.ijse.spring.dto.queryInterfaces.OrderDetailsInterface;
import lk.ijse.spring.dto.res.ResponseOrderDetailsDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.OrderItem_PK;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.PlaceOrderRepo;
import lk.ijse.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private  final PlaceOrderRepo placeOrderRepo;

    private final OrderDetailsRepo orderDetailsRepo;

    private final ItemRepo itemRepo;

    private final ModelMapper mapper;

    @Autowired
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
            Orders save = placeOrderRepo.save(order);



            if (dto.getOrderDetailsDto().size()<1)throw new RuntimeException("No item added");

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

    public void updateOrder(OrderDto dto) {
        if(placeOrderRepo.existsById(dto.getOId())){
            Orders order = mapper.map(dto, Orders.class);
            if(dto.getOrderDetailsDto().size()<1)throw new RuntimeException("No item added");

            for(OrderDetails od:order.getOrderDetails()){
                Item item = itemRepo.findById(od.getItemCode()).get();
                OrderDetails previous = orderDetailsRepo.findById(new OrderItem_PK(od.getOid(),od.getItemCode())).get();

                int newQty= od.getQty();
                int preQty = previous.getQty();
                if(newQty>preQty){
                    int dif = newQty - preQty;
                    item.setQtyOnHand(item.getQtyOnHand()-dif);
                }else if(newQty<preQty){
                    int dif = preQty - newQty;
                    item.setQtyOnHand(item.getQtyOnHand()+dif);
                }else
                itemRepo.save(item);
            }
            placeOrderRepo.deleteById(dto.getOId());
            placeOrderRepo.save(order);

        }else {
            throw  new RuntimeException("Update filed");
        }
    }

    public OrderDto find(String id) {
        Orders orders = placeOrderRepo.findById(id).get();
        OrderDto map = mapper.map(orders, OrderDto.class);
        return map;
    }

    public List<OrderDto> findAll() {
        List<Orders> all = placeOrderRepo.findAll();
    return    mapper.map(all,new TypeToken<List<OrderDto>>(){}.getType());
     /*   ArrayList<OrderDto> orderDtos = new ArrayList<OrderDto>();

        List<OrderDetailsDto> orderDetailsDtos=new ArrayList<OrderDetailsDto>();


        ;
        for(Orders orders:all){
            orderDtos.add(new OrderDto(
                    orders.getOid(),
                    orders.getDate(),
                    orders.getCustomer()
            ));
        }
        return orderDtos;*/

    }

    public List<ResponseOrderDetailsDto> getAllOrdersDetails() {
        List<OrderDetailsInterface> responseOrderDetailsDtos=placeOrderRepo.getAllOrderDetails();
     return mapper.map(responseOrderDetailsDtos,new TypeToken<List<ResponseOrderDetailsDto>>(){}.getType());

    }

    public void delete(String id) {
        placeOrderRepo.deleteById(id);
    }
}
