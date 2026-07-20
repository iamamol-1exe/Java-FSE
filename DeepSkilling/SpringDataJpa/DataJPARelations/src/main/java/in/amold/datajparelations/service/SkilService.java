package in.amold.datajparelations.service;

import in.amold.datajparelations.model.Employee;
import in.amold.datajparelations.model.Skill;
import in.amold.datajparelations.repository.SkilRepository;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;


@Service
public class SkilService {

    private SkilRepository repository;

    public SkilService(SkilRepository repository){
        this.repository = repository;
    }

    public void addSkill(Skill skill){
        repository.save(skill);
    }
    public List<Skill> getSkills(){
        return repository.findAll();
    }
    public Skill getSkillById(Long skillId){
        return repository.findById(skillId).get();
    }
}
