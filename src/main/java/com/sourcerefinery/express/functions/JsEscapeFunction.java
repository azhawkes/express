package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it safe for JavaScript.
 */
public class JsEscapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.escapeJavaScript(Converter.toString(arg));
    }
}
