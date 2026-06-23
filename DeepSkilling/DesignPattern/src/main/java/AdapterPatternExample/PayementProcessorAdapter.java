package AdapterPatternExample;

public class PayementProcessorAdapter implements PaymentProcessor {


    CreditCardPayementProcessor creditCardPayementProcessor;

    public void setCreditCardPayementProcessor(CreditCardPayementProcessor creditCardPayementProcessor) {
        this.creditCardPayementProcessor = creditCardPayementProcessor;
    }

    @Override
    public void processPayment() {
        creditCardPayementProcessor.processPaymentWithCard();
    }
}
