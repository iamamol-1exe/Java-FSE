package in.amold.springrest.repository;

import in.amold.springrest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository  extends JpaRepository<Country,String> {
}
