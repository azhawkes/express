package com.sourcerefinery.express;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it safe for JavaScript.
 */
public class JsEscapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.escapeJavaScript(arg);
    }
}
