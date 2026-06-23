package StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("PayPal Payment - " + amount);
    }
}
