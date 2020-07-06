package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;

import java.util.Base64;

/**
 * Decodes a Base64 string to a regular UTF-8 string. Normally it would be naive to assume it contains a string,
 * but for the purposes of this library and function it's okay.
 */
public class Base64DecodeFunction implements Function {
    @Override
    public Object evaluate(Object o) throws EvaluationException {
        try {
            return new String(Base64.getDecoder().decode(Converter.toString(o)));
        } catch (Exception e) {
            throw new EvaluationException("failed to Base64 decode value [" + o + "] to a string");
        }
    }
}
