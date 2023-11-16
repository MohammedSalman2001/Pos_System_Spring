package lk.ijse.spring.repo;

import lk.ijse.spring.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    public void deleteByEmail(String email);
    User findByEmail(String email);

    boolean existsByNicNo(String nic);
}
