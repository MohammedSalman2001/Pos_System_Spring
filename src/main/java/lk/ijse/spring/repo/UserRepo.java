package lk.ijse.spring.repo;

import lk.ijse.spring.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {
    public void deleteByEmail(String email);
    User findByEmail(String email);

    boolean existsByNicNo(String nic);

    @Modifying
    @Query(value = "UPDATE User SET username=?,password=?,nicNo=?,gender=?,contact=?,address=? WHERE email=?",nativeQuery = true)
    public void updateUser(String userName,
                           String password,
                           String nicNo,
                           String gender,
                           String contact,
                           String address,
                           String email);
}
