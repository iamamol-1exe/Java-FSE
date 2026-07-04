package com.amolD;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {

    @Test
    public void shouldCreateContact(){
        Main main = new Main();
        main.addContact("Amol","Dawane","0787517108");
        Assertions.assertFalse(main.getAllContacts().isEmpty());
        Assertions.assertEquals(1,main.getAllContacts().size());
    }

}
