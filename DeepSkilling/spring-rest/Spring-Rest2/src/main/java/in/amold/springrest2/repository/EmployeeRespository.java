package in.amold.springrest2.repository;

import in.amold.springrest2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository  extends JpaRepository<Employee,Long> {
}
