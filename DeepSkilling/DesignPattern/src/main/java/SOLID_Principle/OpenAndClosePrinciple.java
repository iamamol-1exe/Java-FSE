package SOLID_Principle;


public class OpenAndClosePrinciple {
    public static void main(String[] args) {
        I2DShape circle = new Circle(34);
        I2DShape rectangle = new Rectangle(34, 40);

        AreaCalculator  areaCalculator = new AreaCalculator();
        System.out.println( areaCalculator.calculateArea(rectangle));
        System.out.println(areaCalculator.calculateArea(circle));
    }
}

interface IShape{

}
interface I2DShape extends  IShape{
    double area();
}

class Circle implements I2DShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}


class Rectangle implements I2DShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class AreaCalculator {
    public double calculateArea(I2DShape shape) {
        return shape.area();
    }
}

//class Triangle implements I2DShape {
//    @Override
//    public double area() {
//        return 1/2 * ;
//    }
//}
