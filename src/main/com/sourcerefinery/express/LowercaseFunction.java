package com.sourcerefinery.express;

import com.sourcerefinery.express.Function;

/**
 * Simple function that turns a string to uppercase.
 */
public class LowercaseFunction implements Function {
    public String evaluate(String payload) {
        return payload.toLowerCase();
    }
}
