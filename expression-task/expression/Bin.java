package expression;

import java.util.Objects;

public abstract class Bin implements MyExpression {
    protected final MyExpression first;
    protected final MyExpression second;
    private final char symbol;
    protected abstract int count(int x, int y); // TODO: rename to calc

    public Bin(MyExpression first, MyExpression second, char symbol){
        this.first = first;
        this.second = second;
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return "(" + first.toString() + " " + symbol + " " + second.toString() + ")";
    }

    @Override
    public int evaluate(int num){

        return count(first.evaluate(num), second.evaluate(num));
    }
    @Override
    public int evaluate(int x, int y, int z){
        return count(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    @Override
    public boolean equals(Object myExpression) {
        if (myExpression instanceof Bin operation){
            return symbol == operation.symbol &&
                    first.equals(operation.first) &&
                    second.equals(operation.second);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(Objects.hashCode(first), Objects.hashCode(second), Objects.hashCode(symbol));
    }

}
