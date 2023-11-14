package shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====RECTANGLE-RECTANGLE=====");
        {
            Rectangle rect = new Rectangle("rect", 2, 3);
            System.out.println(rect); // rect
            System.out.println(rect.perimeter()); // 10
            System.out.println(rect.area()); // 6
        }
        System.out.println("=====SHAPE-RECTANGLE=====");
        {
            Shape rect = new Rectangle("rect", 2, 3); // Now type shape
            System.out.println(rect); // rect
            System.out.println(rect.perimeter()); // 10
            System.out.println(rect.area()); // 6
        }
        System.out.println("=====LIST OF SHAPES=====");
        {
            final Scanner scanner = new Scanner(System.in);
            final List<Shape> shapes = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                String type = scanner.next();
                if (type.equals("rect")) {
                    double w = scanner.nextDouble();
                    double h = scanner.nextDouble();
                    shapes.add(new Rectangle("rect" + (i + 1), w, h));
                } else if (type.equals("circle")) {
                    double r = scanner.nextDouble();
                    shapes.add(new Circle("circle" + (i + 1), r));
                } else if (type.equals("triangle")) {
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();
                    shapes.add(new Triangle("triangle" + (i + 1), a, b, c));
                } else {
                    System.out.println("Undefined type of a shape.");
                    return;
                }
            }

            for (Shape shape : shapes) {
                System.out.println(shape + ": ");
                System.out.println("    P = " + shape.perimeter());
                System.out.println("    S = " + shape.area());
            }
        }
    }
}
