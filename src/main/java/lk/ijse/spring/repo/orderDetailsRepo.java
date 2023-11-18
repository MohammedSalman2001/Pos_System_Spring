package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface orderDetailsRepo extends JpaRepository<OrderDetails,String> {

}
