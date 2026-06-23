package DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier slackNotifierDecorator =  new SlackNotifierDecorator(emailNotifier);
//        slackNotifierDecorator.sent();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
//        smsNotifier.sent();

        Notifier notifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        notifier.sent();
    }
}
