package com.example.contact_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class EmployeeContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public EmployeeContactDetails(Long id, String name, String phone) {
//        this.id = id;
//        this.name = name;
//        this.phone = phone;
//    }
}
