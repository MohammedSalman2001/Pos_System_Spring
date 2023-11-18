package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "UPDATE customer SET name=?,address=?,salary=? WHERE  nic=?",nativeQuery = true)
    public void updateCustomer(String name,String address,double salary,String nic);

}
