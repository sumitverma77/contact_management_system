package com.example.contact_management_system.service;

import com.example.contact_management_system.builder.DTOConverter;
import com.example.contact_management_system.constant.messageConstant;
import com.example.contact_management_system.request.AddRequest;
import com.example.contact_management_system.request.DeleteRequest;
import com.example.contact_management_system.request.SearchByNameRequest;
import com.example.contact_management_system.request.SearchByPhoneRequest;
import com.example.contact_management_system.response.AddResponse;
import com.example.contact_management_system.response.DeleteResponse;
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
    public AddResponse  addService(AddRequest addRequest)
    {
        AddResponse addResponse = new AddResponse();
        Optional<EmployeeContactDetails> employeeContactDetails= Optional.ofNullable(contactRepo.findByPhone(addRequest.getPhone()));
        if(employeeContactDetails.isPresent())
        {
            addResponse.setId(employeeContactDetails.get().getId());
            addResponse.setMsg(messageConstant.alreadyPresent);
        }
        else {
            EmployeeContactDetails newContact= DTOConverter.convertAddRequestToEntity(addRequest);
           Optional<EmployeeContactDetails> savedDetails= Optional.of(contactRepo.save(newContact));
            addResponse.setId(savedDetails.get().getId());
       addResponse.setMsg(messageConstant.savedSeccessfully);
        }
        return addResponse;
    }
    public DeleteResponse deleteService(DeleteRequest deleteRequest)
    {
        DeleteResponse deleteResponse = new DeleteResponse();
        Optional<EmployeeContactDetails>    employeeContactDetails=contactRepo.findById(deleteRequest.getId());
          if(employeeContactDetails.isPresent()) {
              contactRepo.deleteById(deleteRequest.getId());
              deleteResponse.setMsg(messageConstant.deltedsuccessfully);
          }
          else {
              deleteResponse.setMsg(messageConstant.contactNotPresent);
        }
  return deleteResponse;
    }
public List<EmployeeContactDetails> searchByName(SearchByNameRequest searchByNameRequest)
{
    List<EmployeeContactDetails> employeeContactDetails = contactRepo.findAllByNameStartingWith(searchByNameRequest.getPrefix());
    return employeeContactDetails;
}
public  List<EmployeeContactDetails> searchByPhone(SearchByPhoneRequest searchByPhoneRequest) {
    List<EmployeeContactDetails> employeeContactDetails=contactRepo.findAllByPhoneStartingWith(searchByPhoneRequest.getPrefix());
    return  employeeContactDetails;
}
}
