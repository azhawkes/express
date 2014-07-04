package com.sourcerefinery.express;

/**
 * An expression that represents a literal string.
 */
public class StringExpression extends Expression {
    private String value;

    public StringExpression(String value) {
        this.value = value;
    }

    public String evaluate(ExpressionContext context) {
        return value;
    }
}
