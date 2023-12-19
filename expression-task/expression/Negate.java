package expression;

public class Negate extends Unary {
    public Negate(MyExpression part) {
        super('-', part);
    }

    @Override
    protected int count(int x) {
        return -x;
    }
}
