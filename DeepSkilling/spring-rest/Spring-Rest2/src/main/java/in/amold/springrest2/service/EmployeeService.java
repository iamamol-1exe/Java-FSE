package in.amold.springrest2.service;


import in.amold.springrest2.model.Employee;
import in.amold.springrest2.repository.EmployeeRespository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRespository respository;
    private final ApplicationContext context;

    public EmployeeService(EmployeeRespository respository,ApplicationContext context) {
        this.respository = respository;
        this.context = context;
    }
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(context.getBean("employee1", Employee.class));
        list.add(context.getBean("employee2", Employee.class));
        list.add(context.getBean("employee3", Employee.class));

        return list;
    }
}
