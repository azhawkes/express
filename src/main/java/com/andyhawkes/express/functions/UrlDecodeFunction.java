package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;

import java.net.URLDecoder;

/**
 * Basic URL decoding on a string.
 */
public class UrlDecodeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        try {
            return URLDecoder.decode(Converter.toString(arg), "UTF-8");
        } catch (Exception e) {
            throw new EvaluationException("failed to decode URL encoded string [" + arg + "]");
        }
    }
}
