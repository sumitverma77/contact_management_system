package com.example.contact_management_system.dto.request;

public class AddRequest {
    private String name;
    private String phone ;

    public String getName() {
        return name;
    }

    public AddRequest(String name, String phone) {
        this.name = name;
        this.phone = phone;
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

}
