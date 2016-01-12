package com.sourcerefinery.express;

import com.sourcerefinery.express.exceptions.EvaluationException;

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

    public String evaluate(ExpressionContext context) throws EvaluationException {
        Function function = context.getFunction(name);

        if (function != null) {
            Object value = function.evaluate(payload.evaluate(context));

            if (value != null) {
                return String.valueOf(value);
            }
        }

        return "";
    }
}
