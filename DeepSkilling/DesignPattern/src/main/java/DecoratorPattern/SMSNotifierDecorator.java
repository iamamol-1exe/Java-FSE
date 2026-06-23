package DecoratorPattern;

public class SMSNotifierDecorator extends  NotifierDecorator {
    public SMSNotifierDecorator(Notifier decorator) {
        super(decorator);
    }

    @Override
    public void sent() {
        super.sent();
        // additional functionality
        System.out.println("SMS sent");
    }
}
