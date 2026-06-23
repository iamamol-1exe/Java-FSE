package ProxyPatternDesign;

public class RealImage implements Image {

    String name;
    public RealImage(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("RealImage");
    }
}
