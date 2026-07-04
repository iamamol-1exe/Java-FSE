package mcp.amolD;


import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    @Test
    @Tag("calculator")
    @Order(1)
    public void testAddition(){
        Calculator adder = new Calculator();
        Assertions.assertEquals(3,adder.add(1,2));
    }

    @Test
    @Tag("calculator")
    @Order(2)
    public void testSubtraction(){
        Calculator obj = new Calculator();
        Assertions.assertEquals(3,obj.sub(7,4));
    }


    @Test
    @Tag("calculator")
    @Order(3)
    public void testMultiplication(){
        Calculator obj = new Calculator();
        Assertions.assertEquals(2,obj.div(4,2));
    }

    @Test
    @Tag("calculator")
    @Order(4)
    public void testDivision(){
        Calculator obj = new Calculator();
        Assertions.assertThrows(ArithmeticException.class,()->{
            obj.div(5,0);
        });
    }

}
