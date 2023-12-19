package expression;

public class Subtract extends Bin{
    public Subtract(MyExpression x, MyExpression y){
        super(x, y, '-');
    }
    public int count(int x, int y){
        return x - y;
    }
}
