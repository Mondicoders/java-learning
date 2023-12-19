package expression;

public abstract class Unary implements MyExpression {
    private final char operation;

    private final MyExpression part;

    protected Unary(char operation, MyExpression part) {
        this.operation = operation;
        this.part = part;
    }

    protected abstract int count(int x);

    @Override
    public String toString() {
        return operation + "(" + part.toString() + ")";
    }

    @Override
    public int evaluate(int x) {
        return count(part.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return count(part.evaluate(x, y, z));
    }
}
