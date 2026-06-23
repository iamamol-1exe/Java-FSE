package DecoratorPattern;

public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier decorator) {
        super(decorator);
    }

    @Override
    public void sent() {
        super.sent();
        //additional functionality
        System.out.println("Slack sent");
    }
}
