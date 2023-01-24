package com.example.demo.Employees;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Pageable;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;


    public List<Employees> getEmployees(){
        Pageable firstPage = (Pageable) PageRequest.of(0,10);
        Page<Employees> pagedResult  = employeesRepository.findAll((org.springframework.data.domain.Pageable) firstPage);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }
        else{
            return new ArrayList<Employees>();
        }
    }

    public void createEmployee(Employees employee){
        employeesRepository.save(employee);
    }

    public Optional<Employees> getEmployeeById(Integer id) {
        return employeesRepository.findById(id);
    }

    public void deleteEmployee (Integer id){
        employeesRepository.deleteById(id);
    }
}
