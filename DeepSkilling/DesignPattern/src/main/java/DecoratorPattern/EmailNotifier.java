package DecoratorPattern;

public class EmailNotifier implements Notifier {
    @Override
    public void sent() {
        System.out.println("Email sent");
    }
}
