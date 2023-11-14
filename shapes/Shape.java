package shapes;

public abstract class Shape implements ShapeMethods {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
