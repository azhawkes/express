package com.andyhawkes.express;

import com.andyhawkes.express.exceptions.EvaluationException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

    public InputStream evaluate(ExpressionContext context) throws EvaluationException {
        try {
            Function function = context.getFunction(name);

            if (function != null) {
                Object value = function.evaluate(payload.evaluate(context));

                if (value instanceof String) {
                    return new ByteArrayInputStream(((String) value).getBytes());
                } else if (value instanceof Number) {
                    return new ByteArrayInputStream(value.toString().getBytes());
                } else if (value instanceof InputStream) {
                    return (InputStream) value;
                }
            }
        } catch (Exception e) {
            throw new EvaluationException("failed to evaluate function");
        }

        return new ByteArrayInputStream(new byte[0]);
    }
}
