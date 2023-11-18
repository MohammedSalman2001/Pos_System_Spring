package lk.ijse.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;

    @Column(unique = true)
    private String nic;
    private double salary;



}
