package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;

import java.net.URLDecoder;

/**
 * Basic URL decoding on a string.
 */
public class UrlDecodeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        try {
            return URLDecoder.decode((String) arg, "UTF-8");
        } catch (Exception e) {
            throw new EvaluationException("failed to decode URL encoded string [" + arg + "]");
        }
    }
}
