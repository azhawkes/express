package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it safe for JavaScript.
 */
public class JsUnescapeFunction implements Function {
    public Object evaluate(Object arg) {
        return StringEscapeUtils.unescapeJavaScript((String) arg);
    }
}
