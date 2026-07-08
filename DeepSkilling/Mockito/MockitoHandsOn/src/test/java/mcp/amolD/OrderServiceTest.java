package mcp.amolD;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @Test
    void verifyOrderTest(){
        PaymentService paymentService = mock(PaymentService.class);
        NotificationService notificationService = mock(NotificationService.class);

        doNothing().when(paymentService).validate();
        doNothing().when(paymentService).process();
        doNothing().when(notificationService).sendNotification();

        OrderService orderService = new OrderService(notificationService,paymentService);

        orderService.orderItem();

        InOrder inOrder = inOrder(notificationService,paymentService);

        inOrder.verify(paymentService).validate();
        inOrder.verify(paymentService).process();
        inOrder.verify(notificationService).sendNotification();


    }

}
