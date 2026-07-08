package mcp.amolD;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class MyServiceTest {

    @Test
    void test(){
            ExternalApi api = mock(ExternalApi.class);
            MyService service = new MyService(api);

            when(api.getData()).thenReturn("343");

            String ans = service.fetchData();

            assertEquals(ans,"343");

    }


    @Test
    void testVerifyInteraction(){
        ExternalApi api = mock(ExternalApi.class);

        MyService service = new MyService(api);
        when(api.getData()).thenReturn("$34354");

        String ans = service.fetchData();
        assertEquals(ans,"$34354");

        verify(api,times(1)).getData();

    }

    @Test
    void argumentMatcherTest(){
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        when(api.getData(anyInt())).thenReturn("543");

        String ans = service.fetchData(100);
        assertEquals(ans,"543");

        verify(api,times(1)).getData(100);
    }


    @Test
    public void voidMethodTest(){
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        doNothing().when(api).printData(anyString());

        service.printData("Ttrtr");

        verify(api).printData("Ttrtr");


        doThrow(new RuntimeException("Email service down"))
                .when(api)
                .printData(anyString());

        assertThrows(RuntimeException.class, () -> {
            service.printData("abc@gmail.com");
        });
    }


    @Test
    void multipleReturnTest() {
        ExternalApi api = mock(ExternalApi.class);

        when(api.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        assertEquals("First", api.getData());
        assertEquals("Second", api.getData());
        assertEquals("Third", api.getData());

        verify(api, times(3)).getData();
    }




}
