package com.example.contact_management_system.service;

import com.example.contact_management_system.dto.request.AddRequest;
import com.example.contact_management_system.dto.request.DeleteRequest;
import com.example.contact_management_system.dto.request.SearchByNameRequest;
import com.example.contact_management_system.dto.response.AddResponse;
import com.example.contact_management_system.dto.response.DeleteResponse;
import com.example.contact_management_system.entity.EmployeeContactDetails;
import com.example.contact_management_system.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepo contactRepo;
    public AddResponse addService(AddRequest addRequest)
    {
        AddResponse addResponse = new AddResponse();
        try
        {
            EmployeeContactDetails employeeContactDetails=contactRepo.findByPhone(addRequest.getPhone());
            //ye query Null return kr rha hai but delete wali nhi krr rhi to kaise pta chlega
            addResponse.setId(employeeContactDetails.getId());
            addResponse.setMsg("Contact already prsent");
        }
        catch(Exception e)
        {
            EmployeeContactDetails newContact=new EmployeeContactDetails();

            newContact.setName(addRequest.getName());
            newContact.setPhone(addRequest.getPhone());
            contactRepo.save(newContact);
            EmployeeContactDetails details=contactRepo.findByPhone(addRequest.getPhone());
            addResponse.setId(details.getId());
            addResponse.setMsg("contact added sucessfully");

        }


//        if(employeeContactDetails!=null)
//        {
//
//             addResponse.setId(employeeContactDetails.getId());
//             addResponse.setMsg("Contact already prsent");
//            System.out.println("hello");
//        }
//        else {
//            EmployeeContactDetails newContact=new EmployeeContactDetails();
//
//            newContact.setName(addRequest.getName());
//            newContact.setPhone(addRequest.getPhone());
//            contactRepo.save(newContact);
//            EmployeeContactDetails details=contactRepo.findByPhone(addRequest.getPhone());
//            addResponse.setId(details.getId());
//            addResponse.setMsg("contact added sucessfully");
//        }

        return addResponse;
    }
    public DeleteResponse deleteService(DeleteRequest deleteRequest)
    {
        DeleteResponse deleteResponse = new DeleteResponse();
        Optional<EmployeeContactDetails>    employeeContactDetails=contactRepo.findById(deleteRequest.getId());
          if(employeeContactDetails.isPresent()) {
              contactRepo.deleteById(deleteRequest.getId());
              deleteResponse.setMsg("Sucesfully deleted");
          }
          else {
              deleteResponse.setMsg("Contact not present");
        }
  return deleteResponse;
    }
public List<EmployeeContactDetails> searchByName(SearchByNameRequest searchByNameRequest)
{
    String namePrefix = searchByNameRequest.getPrefix();

    // Use the repository method to find matching EmployeeContactDetails
    List<EmployeeContactDetails> employeeContactDetails = contactRepo.findAllByNameStartingWith(namePrefix);

    return employeeContactDetails;

}


}
