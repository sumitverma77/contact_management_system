package com.example.contact_management_system.repo;

import com.example.contact_management_system.entity.EmployeeContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<EmployeeContactDetails,Long> {
    EmployeeContactDetails findByPhone(String phone);
    //apni custom query kaise likhe .. find by phone ye to khud likh dega aur esko kaise pta ki phone wale colum me hi find krna  hai ?
}
