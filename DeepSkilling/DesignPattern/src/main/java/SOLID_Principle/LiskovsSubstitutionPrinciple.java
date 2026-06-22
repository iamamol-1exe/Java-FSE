package SOLID_Principle;

public class LiskovsSubstitutionPrinciple {

    public static void main(String[] args) {
        Sqaure1 sqaure1 = new Sqaure1(54);
        System.out.println( "area of the square" + sqaure1.area());
    }
}
class Rectangle1 {
    private double length;
    private double width;
    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double area() {
        return length * width;
    }
}


class Sqaure1 extends Rectangle1 {
        Sqaure1(double size) {
            super(size,size);
        }

        public double area() {
            return super.area();
        }
}
