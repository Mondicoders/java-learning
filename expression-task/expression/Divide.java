package expression;

public class Divide extends Bin{
    public Divide(MyExpression x, MyExpression y){
        super(x, y, '/');
    }
    public int count(int x, int y){
        return x / y;
    }
}
