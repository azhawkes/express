package com.andyhawkes.express;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * An expression that represents a number.
 */
public class NumberExpression extends Expression {
    private String value;

    public NumberExpression(String value) {
        this.value = value;
    }

    public InputStream evaluate(ExpressionContext context) {
        return new ByteArrayInputStream(value.getBytes());
    }
}
