package CommandPatternExample;

public class Light {
    private Command lightOffCommand;
    private Command lightOnCommand;
    private RemoteControl remoteControl = new RemoteControl();

    void turnOn() {
        if (lightOnCommand == null) {
            lightOnCommand = new LightOnCommand();
        }
        remoteControl.setCommand(lightOnCommand);
        remoteControl.execute();

    }

    void turnOff() {
        if (lightOffCommand == null) {
            lightOffCommand = new LightOffCommand();
        }
        remoteControl.setCommand(lightOffCommand);
        remoteControl.execute();

    }
}
