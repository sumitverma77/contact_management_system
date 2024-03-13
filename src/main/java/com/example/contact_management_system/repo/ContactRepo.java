package com.example.contact_management_system.repo;

import com.example.contact_management_system.entity.EmployeeContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<EmployeeContactDetails,Long> {
    
}
