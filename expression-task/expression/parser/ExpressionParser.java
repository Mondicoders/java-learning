package expression.parser;

import expression.*;

import java.util.function.Function;

public class ExpressionParser extends BaseParser implements TripleParser {
    private  String expression;

    private String getMessageForException(String message, int pos) {
        pos--;
        return message + ": " + expression.substring(Math.max(0, pos - 15), pos)
                + "-->" + expression.charAt(pos) + (pos + 1 < expression.length() ? ("<--" + expression.substring(pos + 1, Math.min(pos + 15, expression.length())))
                : "<--"
        )+ " at position " + pos;
    }

    @Override
    public TripleExpression parse(String expression) {
        this.expression = expression;
        setSource(new StringSource(expression));
        MyExpression res = expr();
        if (!eof()) {
            if (take(')')) {
                throw error(getMessageForException("found extra )", getPos()));
            }
            throw error(getMessageForException("excepted eof", getPos()));
        }
        return res;
    }

    private MyExpression prim() {
        skipWhitespaces();
        if (take('(')) {
            MyExpression left = expr();
            if (!take(')')) {
                throw error(getMessageForException("no closing parenthesis", getPos()));
            }
            return left;
        } else if (between('0', '9')) {
            return parseConst(false);
        } else if (between('x', 'z')) {
            return parseVariable();
        } else if (take('-')) {
            if (between('0', '9')) {
                return parseConst(true);
            }
            return new Negate(prim());
        }
        throw error(getMessageForException("unexcepted character", getPos()));
    }

    private MyExpression term() {
        MyExpression left = prim();
        skipWhitespaces();
        while (test('*') || test('/')) {
            left = parseBinOperation(take(), left, prim());
            skipWhitespaces();
        }
        return left;
    }

    private MyExpression expr() {
        MyExpression left = term();
        skipWhitespaces();
        while (test('+') || test('-')) {
            left = parseBinOperation(take(), left, term());
            skipWhitespaces();
        }
        return left;
    }

    private Variable parseVariable() {
        return new Variable(String.valueOf(take()));
    }

    private Const parseConst(boolean minus) {
        final StringBuilder builder = new StringBuilder();
        if (minus) {
            builder.append('-');
        }
        while (between('0', '9')) {
            builder.append(take());
        }
        skipWhitespaces();
        if (between('0', '9')) {
            throw error(getMessageForException("spaces in number", getPos()));
        }
        return new Const(Integer.parseInt(builder.toString()));
    }

    private Bin parseBinOperation(char op, final MyExpression x, final MyExpression y) {
        return switch (op) {
            case '+' -> new Add(x, y);
            case '-' -> new Subtract(x, y);
            case '*' -> new Multiply(x, y);
            case '/' -> new Divide(x, y);
            default -> throw new IllegalArgumentException("Unsupported operation");
        };
    }
}
