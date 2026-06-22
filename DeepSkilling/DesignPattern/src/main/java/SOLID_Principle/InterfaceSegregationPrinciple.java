package SOLID_Principle;

public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {
        I3DShape cube = new Cube(54);
        System.out.println(cube.surfaceArea());
    }

}




interface I3DShape extends IShape {
    public double surfaceArea();
}


class Cube implements I3DShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double surfaceArea() {
        return side*side * side;
    }
}
