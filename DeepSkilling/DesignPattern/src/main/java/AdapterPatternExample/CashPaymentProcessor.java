package AdapterPatternExample;

public class CashPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment() {
        System.out.println("Cash Payment");
    }
}
