package in.amold.springrest2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:employee.xml","classpath:department.xml"})
public class Appconfig {
}
