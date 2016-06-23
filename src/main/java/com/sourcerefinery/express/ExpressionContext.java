package com.sourcerefinery.express;

/**
 * Context for evaluating an expression. Implementations should keep track of variable and function state.
 */
public interface ExpressionContext {
    public String getVariable(String name);

    public String getVariable(String name, int index);

    public Function getFunction(String name);
}
