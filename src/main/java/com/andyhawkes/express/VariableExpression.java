package com.andyhawkes.express;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * An expression that references a simple variable value.
 */
public class VariableExpression extends Expression {
    private String name;
    private int index = -1;

    public VariableExpression(String name) {
        this.name = name;
    }

    public VariableExpression(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public InputStream evaluate(ExpressionContext context) {
        if (index == -1) {
            return new ByteArrayInputStream(context.getVariable(name).getBytes());
        } else {
            return new ByteArrayInputStream(context.getVariable(name, index).getBytes());
        }
    }
}
