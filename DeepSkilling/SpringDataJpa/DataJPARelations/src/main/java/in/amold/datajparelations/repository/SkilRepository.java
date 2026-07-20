package in.amold.datajparelations.repository;

import in.amold.datajparelations.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkilRepository extends JpaRepository<Skill,Long> {
}
