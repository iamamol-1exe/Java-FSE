package AdapterPatternExample;

public class Main {
    public static void main(String[] args) {
        PayementProcessorAdapter adapter = new PayementProcessorAdapter();
        adapter.setCreditCardPayementProcessor(new CreditCardPayementProcessor());
        adapter.processPayment();

        PaymentProcessor cashPaymentProcessor = new CashPaymentProcessor();
        cashPaymentProcessor.processPayment();
    }
}
