package in.amold.springrest.controller;

import in.amold.springrest.exception.CountryNotFoundException;
import in.amold.springrest.model.Country;
import in.amold.springrest.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {


    private CountryService countryService;

    public CountryController(CountryService service){
        this.countryService = service;
    }

    @RequestMapping("/country")
    public String getCountryIndia(){
        return "India";
    }


    @RequestMapping("/getAllCountries")
    String [] getAllCountries(){
        return new String[]{"india","america",};
    }


    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountryByCode(code);
    }
}
