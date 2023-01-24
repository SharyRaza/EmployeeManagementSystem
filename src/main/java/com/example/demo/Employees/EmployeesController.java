package com.example.demo.Employees;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService){
        this.employeesService=employeesService;
    }

    @GetMapping("")
    public List<Employees> getEmployees(){
        return employeesService.getEmployees();
    }

    @PostMapping("/")
    public void createEmployee(@RequestBody  Employees employee){
        employeesService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Employees employee, @PathVariable Integer id) {

        if(employeesService.getEmployeeById(id).isEmpty()){
            System.out.println("No employee with this id exists");

        }
        else{
            Employees existEmployee = employeesService.getEmployeeById(id).get();
            existEmployee.setId(id);
            existEmployee.setEmployeeName(employee.getEmployeeName());
            existEmployee.setEmployeeMobile(employee.getEmployeeMobile());
            existEmployee.setEmployeeAddress(employee.getEmployeeAddress());
            existEmployee.setDateOfJoining(employee.getDateOfJoining());
            existEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
            employeesService.createEmployee(existEmployee);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id){
        try {
            employeesService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            //error message
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
