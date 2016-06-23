package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;

/**
 * Simple function that turns a string to uppercase.
 */
public class LowercaseFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return Converter.toString(arg).toLowerCase();
    }
}
