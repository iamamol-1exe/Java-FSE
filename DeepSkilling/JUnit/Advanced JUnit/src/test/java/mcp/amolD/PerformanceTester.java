package mcp.amolD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class PerformanceTester {

    @Test
    public void performTask(){
        Assertions.assertTimeout(Duration.ofMillis(1020),()->{
            Thread.sleep(1000);
        });
    }

}
