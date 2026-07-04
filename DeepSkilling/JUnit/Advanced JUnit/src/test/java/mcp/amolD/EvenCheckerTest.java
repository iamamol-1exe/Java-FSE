package mcp.amolD;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints =  { 0, 2, 4, 6, 8 })
    public void isEvenTest(int num){

        EvenChecker evenChecker = new EvenChecker();
        Assertions.assertEquals(1,evenChecker.isEven(num));
    }
}
