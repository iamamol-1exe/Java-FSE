package DecoratorPattern;

public abstract class NotifierDecorator implements Notifier {
    Notifier decorator;
    public NotifierDecorator(Notifier decorator) {
        this.decorator = decorator;
    }
    @Override
    public void sent() {
        decorator.sent();
    }
}
