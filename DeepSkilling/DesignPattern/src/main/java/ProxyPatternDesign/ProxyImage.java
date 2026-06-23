package ProxyPatternDesign;

public class ProxyImage implements Image {
    private Image image;
    private String  filename;
    public ProxyImage(String name) {
        this.filename = name;
        this.image = null;
    }
    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.display();
    }
}
