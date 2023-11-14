package shapes;

public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double semi = perimeter() / 2;
        return Math.sqrt(semi * (semi - a) * (semi - b) * (semi - c));
    }

    @Override
    public String abc() {

        return null;
    }
}
