package com.example.contact_management_system.repo;

import com.example.contact_management_system.entity.EmployeeContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<EmployeeContactDetails,Long> {
   //    @Query("SELECT e FROM EmployeeContactDetails e WHERE e.phone = :phone")
    EmployeeContactDetails findByPhone(String phone);
    //apni custom query kaise likhe .. find by phone ye to khud likh dega aur esko kaise pta ki phone wale colum me hi find krna  hai ?
  //  @Query("SELECT e FROM EmployeeContactDetails e WHERE e.name LIKE :prefix%")
    List<EmployeeContactDetails> findAllByNameStartingWith(String prefix);
    //ye sb jaadu kaise ho rha , chatgpt se examples bhe dikha do spring data jpa ke liye
}
