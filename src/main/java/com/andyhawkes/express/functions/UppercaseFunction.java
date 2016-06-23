package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;

/**
 * Simple function that turns a string to uppercase.
 */
public class UppercaseFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return Converter.toString(arg).toUpperCase();
    }
}
