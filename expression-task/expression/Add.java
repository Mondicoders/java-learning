package expression;

public class Add extends Bin{
    public Add(MyExpression x, MyExpression y){
        super(x, y, '+');
    }
    public int count(int x, int y){
       return x + y;
    }
}
