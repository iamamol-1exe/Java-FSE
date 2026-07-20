package in.amold.datajparelations.controller;

import in.amold.datajparelations.model.Department;
import in.amold.datajparelations.model.Employee;
import in.amold.datajparelations.service.EmployeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeService  service;


    public EmployeeController(EmployeService service){
        this.service = service;
    }

    public void addEmployee(Employee employee){
        service.addEmployee(employee);
    }

    public Employee geEmployee(Long id){
        return service.getEmployee(id);
    }

}
