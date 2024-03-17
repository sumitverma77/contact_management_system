package com.example.contact_management_system.controller;

import com.example.contact_management_system.dto.request.AddRequest;
import com.example.contact_management_system.dto.request.DeleteRequest;
import com.example.contact_management_system.dto.request.SearchByNameRequest;
import com.example.contact_management_system.dto.request.SearchByPhoneRequest;
import com.example.contact_management_system.dto.response.AddResponse;
import com.example.contact_management_system.dto.response.DeleteResponse;
import com.example.contact_management_system.entity.EmployeeContactDetails;
import com.example.contact_management_system.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins =   "*")
@RestController
@RequestMapping("/contact")
public class Contacts {

    @Autowired
    private ContactService contactService;
    @PostMapping ("/add")
    public AddResponse add(@RequestBody AddRequest addRequest)
    {
            return  contactService.addService(addRequest);
    }
    @DeleteMapping ("delete")
    public DeleteResponse delete(@RequestBody DeleteRequest deleteRequest)
    {
        return  contactService.deleteService(deleteRequest);
    }
    @GetMapping("search/name")
    public List<EmployeeContactDetails> searchByName(@RequestBody SearchByNameRequest searchByNameRequest)
    {
        return contactService.searchByName(searchByNameRequest);
    }
    @GetMapping("search/phone")
    public List<EmployeeContactDetails> searchByPhone(@RequestBody SearchByPhoneRequest searchByPhoneRequest)
    {
        return contactService.searchByPhone(searchByPhoneRequest);
    }

}
