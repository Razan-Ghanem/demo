package com.example.demo.service;

import com.example.demo.exception.ExceptionMessages;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Invoice;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.InvoiceItemRepository;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends GeneralDemoService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        Specification distinctSpec = (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
        return employeeRepository.findAll(distinctSpec);
    }

    // Todo: Add some code
    public Employee getEmployeeById(long employeeId) {

        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeById(employeeId);

        if (!(optionalEmployee.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }

        return optionalEmployee.get();
    }

    public Employee postInvoice(Employee newEmployee) {

        //newInvoice.getItems().stream().forEach(invoiceItem -> invoiceItem.setInvoice(newInvoice));
        return employeeRepository.save(newEmployee);
    }

    //TODO: check how to do exception handling accross the code
    //TODO: PUT VS POST, What is idempotency ?
    public Employee putEmployee(Employee employee, long employeeId){
        // Find by id, throw exception 404
        Optional<Employee>employeeupdated = employeeRepository.findEmployeeById(employeeId);
        if (!(employeeupdated.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }

        employeeupdated.get().setEmp_role(employee.getEmp_role());
        employeeupdated.get().setEmp_address(employee.getEmp_address());
        employeeupdated.get().setEmp_pass(employee.getEmp_pass());
        employeeupdated.get().setEmp_firstName(employee.getEmp_firstName());
        employeeupdated.get().setEmp_lastName(employee.getEmp_lastName());

        return employeeRepository.save(employeeupdated.get());

    }

    public void deleteEntity(Long employeeId) {
        Optional<Employee> employeeEntity = employeeRepository.findEmployeeById(employeeId);

        // Todo: Return 404
        if (!(employeeEntity.isPresent())) {
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND) ;
        }
        employeeRepository.delete(employeeEntity.get());

    }
}
