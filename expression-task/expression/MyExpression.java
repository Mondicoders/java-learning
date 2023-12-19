package expression;

public interface MyExpression extends Expression, TripleExpression {
    String toString();
    int evaluate(int num);
    int evaluate(int a, int b, int c);
}
