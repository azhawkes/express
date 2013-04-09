package com.sourcerefinery.express;

/**
 * A function expression.
 */
public class FunctionExpression extends Expression {
    private String name;
    private Expression payload;

    public FunctionExpression(String name, Expression payload) {
        this.name = name;
        this.payload = payload;
    }

    public String evaluate(ExpressionContext context) {
        Function function = context.getFunction(name);

        if (function != null) {
            return function.evaluate(payload.evaluate(context));
        } else {
            return "";
        }
    }
}
