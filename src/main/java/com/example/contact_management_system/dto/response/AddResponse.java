package com.example.contact_management_system.dto.response;

public class AddResponse {
  private Long   id;
  private String msg;

//    public AddResponse(String id, String msg) {
//        this.id = id;
//        this.msg = msg;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
