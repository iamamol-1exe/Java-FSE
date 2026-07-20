package in.amold.datajparelations.controller;

import in.amold.datajparelations.model.Department;
import in.amold.datajparelations.service.DepartmentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private DepartmentService service;


    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    public Department getDepartment(Long id){
        return service.getDepartment( id);
    }
    public void addDepartment(Department department){
        service.addDepartment(department);
    }

}
