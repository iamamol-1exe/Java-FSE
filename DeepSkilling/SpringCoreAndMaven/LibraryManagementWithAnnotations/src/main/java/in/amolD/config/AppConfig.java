package in.amolD.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("in.amolD")
@EnableAspectJAutoProxy
public class AppConfig {
}
