package in.amold.ormlearn.service;


import in.amold.ormlearn.model.Country;
import in.amold.ormlearn.repository.ConturyRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static ConturyRespository repo;

    public CountryService(ConturyRespository repo) {
        CountryService.repo = repo;
    }


    @Transactional
    public List<Country> getAllCountry(){
        return repo.findAll();
    }




}
