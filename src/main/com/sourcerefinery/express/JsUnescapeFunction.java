package com.sourcerefinery.express;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it safe for JavaScript.
 */
public class JsUnescapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.unescapeJavaScript(arg);
    }
}
