package in.amold.springrest2.controller;


import in.amold.springrest2.model.Employee;
import in.amold.springrest2.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployess")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
