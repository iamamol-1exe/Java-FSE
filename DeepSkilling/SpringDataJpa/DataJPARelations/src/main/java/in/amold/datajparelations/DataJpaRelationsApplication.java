package in.amold.datajparelations;

import com.sun.tools.javac.Main;
import in.amold.datajparelations.controller.DepartmentController;
import in.amold.datajparelations.controller.EmployeeController;
import in.amold.datajparelations.controller.SkillController;
import in.amold.datajparelations.model.Department;
import in.amold.datajparelations.model.Employee;
import in.amold.datajparelations.model.Skill;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

@SpringBootApplication
public class DataJpaRelationsApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        ApplicationContext context =  SpringApplication.run(DataJpaRelationsApplication.class, args);

//        testAddEmployee(context);
        DataJpaRelationsApplication main = context.getBean(DataJpaRelationsApplication.class);
//        main.testUpdateEmployee(context);
//        main.testGetDepartment(context);
//        main.testAddSkill(context);
        main.testAddSkillToEmployee(context);
    }

    static  void testAddEmployee(ApplicationContext context){
        DepartmentController dc = context.getBean(DepartmentController.class);
        Department d = dc.getDepartment(1L);
        Employee e = new Employee();

        e.setName("amol");
        e.setDepartment(d);
        e.setPermanent(true);
        e.setDateOfBirth(new Date());
        e.setSalary(4343);

        EmployeeController controller = context.getBean(EmployeeController.class);

        controller.addEmployee(e);
    }

    @Transactional
     public void testUpdateEmployee(ApplicationContext context){
        EmployeeController controller = context.getBean(EmployeeController.class);

        Employee employee = controller.geEmployee((long)2);

        DepartmentController dc = context.getBean(DepartmentController.class);
        Department d = dc.getDepartment(2L);

        employee.setDepartment(d);


        controller.addEmployee(employee);
        System.out.println("Updated employee " + employee);

    }

    void testGetDepartment(ApplicationContext context){
        DepartmentController dc = context.getBean(DepartmentController.class);
        Department department = dc.getDepartment(1L);
        System.out.println(department);
        System.out.println(department.getEmployees());
    }

    void testAddSkill(ApplicationContext context){
        SkillController controller = context.getBean(SkillController.class);
        Skill skill = new Skill();
        skill.setName("amol");
        controller.addSkill(skill);

    }

    @Transactional
    public void testAddSkillToEmployee(ApplicationContext context){
        EmployeeController controller = context.getBean(EmployeeController.class);

        Employee employee = controller.geEmployee((long)3);

        DepartmentController dc = context.getBean(DepartmentController.class);
        Department d = dc.getDepartment(2L);

        SkillController skillController =  context.getBean(SkillController.class);
        Skill skill = skillController.getSkill(1L);

        employee.setDepartment(d);
        Set<Skill> skillSet = employee.getSkilledList();

        skillSet.add(skill);
        employee.setSkilledList(skillSet);

        controller.addEmployee(employee);
        System.out.println("Updated employee " + employee);

    }

}
