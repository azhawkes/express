package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;

import java.util.Base64;

/**
 * Encodes data as Base64.
 */
public class Base64EncodeFunction implements Function {
    @Override
    public Object evaluate(Object o) throws EvaluationException {
        try {
            return Base64.getEncoder().encode(Converter.toString(o).getBytes());
        } catch (Exception e) {
            throw new EvaluationException("failed to Base64 encode string [" + o + "]");
        }
    }
}
