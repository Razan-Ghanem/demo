package com.example.demo.controllar;

import com.example.demo.controllar.dto.EmployeeDto;
import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.controllar.dto.InvoiceDto1;
import com.example.demo.controllar.mapper.ControllerMappers;
import com.example.demo.model.Employee;
import com.example.demo.model.Invoice;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeControllar extends GeneralController {
    @Autowired
    EmployeeRepository employeeRepository;
     @Autowired
    EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees= employeeService.getEmployees();
        List<EmployeeDto> employeeDtos = ControllerMappers.mapEmployees(employees);
        return employeeDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long employeeId){

        EmployeeDto employeeDto  = ControllerMappers.mapEmployeeDto(employeeService.getEmployeeById(employeeId));
        return new ResponseEntity(employeeDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> craeteEmployee(@RequestBody EmployeeDto employeeDto) {

        Employee newEmployee = ControllerMappers.mapEmployee(employeeDto);
        EmployeeDto createdEmployeeDto = ControllerMappers.mapEmployeeDto(employeeService.postInvoice(newEmployee));
        return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable ("id") long employeeId ,
                              @RequestBody EmployeeDto employeeDto){
        Employee employee  = ControllerMappers.mapEmployee(employeeDto);
        EmployeeDto updatedEmployeeDto = ControllerMappers.mapEmployeeDto(employeeService.putEmployee(employee,employeeId));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable ("id") long employeeId){
        employeeService.deleteEntity(employeeId);

    }

}
