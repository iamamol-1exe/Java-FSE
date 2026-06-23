package StrategyPatternExample;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new CreditCardPayment();
        PaymentStrategy paymentStrategy2 = new PayPalPayment();

        PaymentContext context = new PaymentContext(paymentStrategy);
        context.execute(434);
        PaymentContext paymentContext2 = new PaymentContext(paymentStrategy2);
        paymentContext2.execute(234);
    }
}
