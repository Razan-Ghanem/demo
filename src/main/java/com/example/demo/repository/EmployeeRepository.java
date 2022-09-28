package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Invoice;
import com.example.demo.model.enums.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    @Query("SELECT employee FROM Employee employee"+
            " where employee.id = ?1" )
    Optional<Employee> findEmployeeById(Long employeeId);
}
