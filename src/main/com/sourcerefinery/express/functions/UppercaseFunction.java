package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;

/**
 * Simple function that turns a string to uppercase.
 */
public class UppercaseFunction implements Function {
    public Object evaluate(Object arg) {
        return ((String) arg).toUpperCase();
    }
}
