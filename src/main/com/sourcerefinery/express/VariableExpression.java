package com.sourcerefinery.express;

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

    public String evaluate(ExpressionContext context) {
        if (index == -1) {
            return context.getVariable(name);
        } else {
            return context.getVariable(name, index);
        }
    }
}
