package in.amold.ormlearn2.service;


import in.amold.ormlearn2.exception.CountryNotFoundException;
import in.amold.ormlearn2.model.Country;
import in.amold.ormlearn2.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private CountryRepository repo;

    public CountryService(CountryRepository repo){
        this.repo = repo;
    }

    @Transactional
    public Country getCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> country =   repo.findById(code);
        if(country.isPresent()){
            return country.get();
        }
        throw new CountryNotFoundException("Country with code " + code + " not found");
    }

    @Transactional
    public void addCountry(Country country){
        repo.save(country);
    }

    @Transactional
    public void updateCountry(String code, Country country) throws CountryNotFoundException {
        Optional<Country> existing = repo.findById(code);
        if(existing.isPresent()){
            Country c = existing.get();
            c.setName(country.getName());
            repo.save(c);
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
    }

    @Transactional
    public List<Country> getCountriesByName(String name){
        return repo.findByName(name);
    }

    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        if(repo.existsById(code)){
            repo.deleteById(code);
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
    }
}

