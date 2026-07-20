package in.amold.datajparelations.service;

import in.amold.datajparelations.model.Employee;
import in.amold.datajparelations.repository.EmployeeRepositoty;
import org.springframework.stereotype.Service;


@Service
public class EmployeService {

    private EmployeeRepositoty repositoty;

    public EmployeService(EmployeeRepositoty repositoty){
        this.repositoty = repositoty;
    }
    public Employee getEmployee(Long id){
        return  repositoty.findById(id).get();
    }

    public  void addEmployee(Employee employee){
        repositoty.save(employee);
    }
}
