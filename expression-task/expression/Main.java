package expression;

import expression.parser.ExpressionParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ExpressionParser parser = new ExpressionParser();
            var expr = parser.parse("(2 + 2");
            System.out.println(expr);
            System.out.println(expr.evaluate(0, 0, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
