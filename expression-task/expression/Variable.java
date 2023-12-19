package expression;

import java.util.Objects;

public class Variable implements MyExpression {
    private final String var;
    public Variable(String var){
        this.var = var;
    }
    public String toString(){
        return var;
    }
    public int evaluate(int num){
        return num;
    }

    @Override
    public int evaluate(int a, int b, int c) {
        return switch (var) {
            case "x" -> a;
            case "y" -> b;
            case "z" -> c;
            default -> throw new IllegalArgumentException("Unsupported variable name");
        };
    }

    @Override
    public boolean equals(Object myExpression){
        if (myExpression instanceof Variable variable){
            return Objects.equals(var, variable.var);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(this.var);
    }
}
