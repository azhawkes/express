package com.sourcerefinery.express;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it HTML-safe.
 */
public class HtmlEscapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.escapeHtml(arg);
    }
}
