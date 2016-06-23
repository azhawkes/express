package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;

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
