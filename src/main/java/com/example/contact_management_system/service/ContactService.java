package com.example.contact_management_system.service;

import com.example.contact_management_system.dto.request.AddRequest;
import com.example.contact_management_system.dto.response.AddResponse;
import com.example.contact_management_system.entity.EmployeeContactDetails;
import com.example.contact_management_system.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepo contactRepo;
    public AddResponse addService(AddRequest addRequest)
    {

        AddResponse addResponse = new AddResponse();
        EmployeeContactDetails employeeContactDetails=contactRepo.findByPhone(addRequest.getPhone());

        System.out.println("abi tk thik hai ");
        System.out.println("abi tk thik hai ");
        if(employeeContactDetails!=null)
        {

             addResponse.setId(employeeContactDetails.getId());
             addResponse.setMsg("Contact already prsent");
            System.out.println("hello");
        }
        else {
            EmployeeContactDetails newContact=new EmployeeContactDetails();

            newContact.setName(addRequest.getName());
            newContact.setPhone(addRequest.getPhone());
            contactRepo.save(newContact);
            EmployeeContactDetails details=contactRepo.findByPhone(addRequest.getPhone());
            addResponse.setId(details.getId());
            addResponse.setMsg("contact added sucessfully");
        }

        return addResponse;
    }
}
