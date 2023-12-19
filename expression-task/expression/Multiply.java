package expression;

public class Multiply extends Bin{

    public Multiply(MyExpression x, MyExpression y){
        super(x, y, '*');
    }
    public int count(int x, int y){
        return x * y;
    }
}
