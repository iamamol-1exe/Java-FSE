package in.amold.datajparelations.service;

import in.amold.datajparelations.model.Department;
import in.amold.datajparelations.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repo){
        this.repository = repo;
    }

    public Department getDepartment(Long id){
        return  repository.findById(id).get();
    }
    public void addDepartment(Department department){
        repository.save(department);
    }
}
