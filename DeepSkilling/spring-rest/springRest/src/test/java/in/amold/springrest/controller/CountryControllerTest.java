package in.amold.springrest.controller;


import in.amold.springrest.exception.CountryNotFoundException;
import in.amold.springrest.model.Country;
import in.amold.springrest.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CountryControllerTest {

    @Test
    void getCountryByCode_ShouldThrowException_WhenCountryNotFound() {

        CountryService mcok1 =  Mockito.mock(CountryService.class);




    }
}
