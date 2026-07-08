package mcp.amolD;

public class OrderService {
    private NotificationService notificationService;
    private PaymentService paymentService;

    public OrderService(NotificationService notificationService, PaymentService paymentService) {
        this.notificationService = notificationService;
        this.paymentService = paymentService;
    }

    public void orderItem(){
        paymentService.validate();
        paymentService.process();
        notificationService.sendNotification();
    }
}
