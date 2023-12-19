package expression;

public class Const implements MyExpression {
    private final int cons; // value
    public Const(int cons){
        this.cons = cons;
    }
    public int getCons(){
        return cons;
    }
    public String toString(){
        return String.valueOf(cons);
    }
    public int evaluate(int num){
        return cons;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        return cons;
    }
    @Override
    public boolean equals(Object myExpression){
        if (myExpression instanceof Const num){
            return cons == num.getCons();
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(this.cons);
    }
}
