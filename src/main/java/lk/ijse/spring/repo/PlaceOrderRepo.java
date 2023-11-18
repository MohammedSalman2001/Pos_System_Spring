package lk.ijse.spring.repo;

import lk.ijse.spring.dto.queryInterfaces.OrderDetailsInterface;
import lk.ijse.spring.dto.res.ResponseOrderDetailsDto;
import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlaceOrderRepo extends JpaRepository<Orders,String> {

    @Query(value = "select c.name ,c.address,c.salary,o.oid,o.date from customer c INNER JOIN  orders o on c.id = o.customerId",nativeQuery = true)
    List<OrderDetailsInterface>  getAllOrderDetails();
}
