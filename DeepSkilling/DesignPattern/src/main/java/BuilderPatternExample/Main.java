package BuilderPatternExample;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .setCpuName("RYZEN 7")                                                   // computer obj with all paramerters with help of the builder method
                .setRamSize(16).setDiskSize(512)
                .createComputer();


        System.out.println(computer);

        Computer computer1 = new Computer.ComputerBuilder() // computer obj without ram size
                .setCpuName("Intel I7")
                .setDiskSize(512)
                .createComputer();
        System.out.println(computer1);
    }
}
