package in.amold.ormlearn;

import in.amold.ormlearn.model.Country;
import in.amold.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Mumbai/Kolkata"));
        ApplicationContext context =  SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Spring Boot Application Started");

        countryService = context.getBean(CountryService.class);
    }

    private static void testGetAllCountries() {
        LOGGER.info("testGetAllCountries");

        List<Country> list = countryService.getAllCountry();
        LOGGER.debug("countries={}", list);
        LOGGER.info("End");

    }

}
