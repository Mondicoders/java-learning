package shapes;

public class Circle extends Shape {
    private final double r;

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return "This is circle " + this.name;
    }

    @Override
    public void abc() {

    }
}
