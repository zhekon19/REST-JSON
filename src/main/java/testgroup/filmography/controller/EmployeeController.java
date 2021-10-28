package testgroup.filmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testgroup.filmography.exception_handling.EmployeeIncorrectData;
import testgroup.filmography.exception_handling.NoSuchEmployeeException;
import testgroup.filmography.model.Employee;
import testgroup.filmography.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("there is no employee with ID = " + id + " in Database" );
        }
        return employee;
    }


}
