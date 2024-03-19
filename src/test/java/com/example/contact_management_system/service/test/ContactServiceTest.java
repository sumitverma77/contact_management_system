package com.example.contact_management_system.service.test;
import com.example.contact_management_system.builder.request.AddRequest;
import com.example.contact_management_system.entity.EmployeeContactDetails;
import com.example.contact_management_system.repo.ContactRepo;
import com.example.contact_management_system.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {
    @Autowired
    ContactService contactService;
    @MockBean
    private ContactRepo contactRepo;
    @MockBean
    private EmployeeContactDetails employeeContactDetails;
    @Test
  public void addServiceWhenContactAlreadyPresent()
    {
        EmployeeContactDetails employeeContactDetails = new EmployeeContactDetails();
        employeeContactDetails.setPhone("843984989428");
        employeeContactDetails.setName("raju");
        employeeContactDetails.setId(Long.valueOf("2"));
        AddRequest addRequest= new AddRequest("raju" , "843984989428");
        when(contactRepo.findByPhone(addRequest.getPhone())).thenReturn(employeeContactDetails);

        assertEquals("Contact already prsent" ,contactService.addService(addRequest).getMsg());
    }
    @Test
    public  void addServiceWhenContactNotPresent()
    {
        AddRequest addRequest = new AddRequest("sumit","8808630994");
        when(contactRepo.findByPhone(addRequest.getPhone())).thenReturn(null);
        EmployeeContactDetails employeeContactDetails = new EmployeeContactDetails();
        employeeContactDetails.setPhone("8808630994");
        employeeContactDetails.setName("sumit");
        when(contactRepo.findByPhone(addRequest.getPhone())).thenReturn(employeeContactDetails);
        assertEquals("contact added sucessfully" , contactService.addService(addRequest).getMsg());
    }





    }
