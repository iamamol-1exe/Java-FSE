package mcp.amolD;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // only one object is begin is created
public class ExceptionThrowerTest {

    @Test
    public void testExceptionThrower(){
        ExceptionThrower exceptionThrower = new ExceptionThrower();
        Assertions.assertThrows(RuntimeException.class,()->{
            exceptionThrower.throwException();
        });
    }

}
