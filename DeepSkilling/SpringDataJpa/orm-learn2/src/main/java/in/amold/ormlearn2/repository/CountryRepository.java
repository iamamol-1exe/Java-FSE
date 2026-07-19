package in.amold.ormlearn2.repository;

import in.amold.ormlearn2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {
    @Query("SELECT c FROM Country c WHERE LOWER(c.name) LIKE LOWER(concat('%',:name,'%')) ORDER BY c.code ASC ")
    public List<Country> findByName(String name);

    public List<Country> findByNameIgnoreCase(String name);
}
