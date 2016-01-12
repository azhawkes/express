package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it safe for JavaScript.
 */
public class JsEscapeFunction implements Function {
    public Object evaluate(Object arg) {
        return StringEscapeUtils.escapeJavaScript((String) arg);
    }
}
