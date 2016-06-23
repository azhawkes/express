package com.andyhawkes.express;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * An expression that represents a literal string.
 */
public class StringExpression extends Expression {
    private String value;

    public StringExpression(String value) {
        this.value = value;
    }

    public InputStream evaluate(ExpressionContext context) {
        return new ByteArrayInputStream(value.getBytes());
    }
}
