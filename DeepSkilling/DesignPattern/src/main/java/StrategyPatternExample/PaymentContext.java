package StrategyPatternExample;

public class PaymentContext {
    PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void execute(int amoount) {
        strategy.pay(amoount);
    }
}
