package com.sourcerefinery.express;

/**
 * Simple function that turns a string to uppercase.
 */
public class UppercaseFunction implements Function {
    public String evaluate(String payload) {
        return payload.toUpperCase();
    }
}
