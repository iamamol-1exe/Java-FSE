package in.amold.springrest2;

import in.amold.springrest2.controller.EmployeeController;
import in.amold.springrest2.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class SpringRest2Application {

    static public  Logger logger =  LoggerFactory.getLogger(SpringBootApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Spring Rest2Application");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        ApplicationContext context = SpringApplication.run(SpringRest2Application.class, args);

        logger.info("Spring Rest2Application started");
        TestGetAllEmployees(context);
    }


    static private void TestGetAllEmployees(ApplicationContext context){
        logger.info("Fetching all employees");
        EmployeeController controller = context.getBean(EmployeeController.class);
        List<Employee> employees = controller.getAllEmployees();
        logger.info("Fetched all employees"+employees.toString());

    }


}
