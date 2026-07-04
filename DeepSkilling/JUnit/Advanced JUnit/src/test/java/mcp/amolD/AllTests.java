package mcp.amolD;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EvenChecker.class,
        CalculatorTest.class,
})
// all test from evechecker and calculator test is runned by suite and selectedclass
//it is used for the grouping test classes
public class AllTests {
}
