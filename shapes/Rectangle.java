package shapes;

public class Rectangle extends Shape {
    private final double w;
    private final double h;

    public Rectangle(String name, double w, double h) {
        super(name);
        this.w = w;
        this.h = h;
    }

    @Override
    public double perimeter() {
        return 2 * (w + h);
    }

    @Override
    public double area() {
        return w * h;
    }

    @Override
    public String abc() {

        return null;
    }
}
