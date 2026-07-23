package in.amold.springrest.service;

import in.amold.springrest.exception.CountryNotFoundException;
import in.amold.springrest.model.Country;
import in.amold.springrest.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository repo;

    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
      Optional<Country> country = repo.findById(code);
      if (country.isPresent()) {
          return country.get();
      }
      else {
          throw new CountryNotFoundException();
      }
    }
}
