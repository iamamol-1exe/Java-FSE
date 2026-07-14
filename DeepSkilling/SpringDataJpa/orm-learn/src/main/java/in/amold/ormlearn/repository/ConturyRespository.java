package in.amold.ormlearn.repository;

import in.amold.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConturyRespository extends JpaRepository<Country,String> {

}
