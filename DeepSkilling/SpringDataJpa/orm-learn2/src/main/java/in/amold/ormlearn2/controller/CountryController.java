package in.amold.ormlearn2.controller;

import in.amold.ormlearn2.exception.CountryNotFoundException;
import in.amold.ormlearn2.model.Country;
import in.amold.ormlearn2.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CountryController {

    private CountryService service;

    public CountryController(CountryService service){
        this.service = service;
    }

    @GetMapping("/get-country/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return service.getCountryByCode(code);
    }

    @PostMapping("/add-country")
    public void addCountry(@RequestBody Country country){
        service.addCountry(country);
    }

    @PatchMapping("/update-country/{code}")
    public String updateCountry(@PathVariable String code, @RequestBody Country country) throws CountryNotFoundException {
        service.updateCountry(code, country);
        return "Country updated successfully";
    }

    @DeleteMapping("/delete-country/{code}")
    public void deleteCountry(@PathVariable String code) throws CountryNotFoundException {
        service.deleteCountry(code);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<String> handleCountryNotFoundException(CountryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search-by-name")
    public List<Country> searchByName(@RequestParam String name){
        return service.getCountriesByName(name);
    }
}
