package com.amolD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    public void shouldCreateContact(){
        Main main = new Main();
        main.addContact("Amol","Dawane","0787517108");
        Assertions.assertFalse(main.getAllContacts().isEmpty());
        Assertions.assertEquals(1,main.getAllContacts().size());
    }


    @Test
    public void shouldCreateContacts(){
        Main main = new Main();
        main.addContact("Amol","Dawane","0787517108");

        Contact contact = main.getContact("0787517108");
        Assertions.assertNotNull(contact);
        Assertions.assertEquals("Dawane",contact.getLastName());
    }
}
