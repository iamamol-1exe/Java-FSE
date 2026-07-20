package in.amold.datajparelations.repository;

import in.amold.datajparelations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoty extends JpaRepository<Employee,Long> {
}
