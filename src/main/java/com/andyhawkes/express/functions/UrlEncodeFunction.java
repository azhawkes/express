package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;

import java.net.URLEncoder;

/**
 * Basic URL encoding on a string.
 */
public class UrlEncodeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        try {
            return URLEncoder.encode(Converter.toString(arg), "UTF-8");
        } catch (Exception e) {
            throw new EvaluationException("failed to urlencode string [" + arg + "]");
        }
    }
}
