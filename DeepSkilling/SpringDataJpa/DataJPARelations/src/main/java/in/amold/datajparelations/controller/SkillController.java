package in.amold.datajparelations.controller;

import in.amold.datajparelations.model.Skill;
import in.amold.datajparelations.service.SkilService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkillController {
    private SkilService service;
    public SkillController(SkilService service){
        this.service = service;
    }
    public void addSkill(Skill skill){
        service.addSkill(skill);
    }

    public Skill getSkill(Long skillId){
        return  service.getSkillById(skillId);
    }
}
