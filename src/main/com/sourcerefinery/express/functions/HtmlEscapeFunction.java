package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it HTML-safe.
 */
public class HtmlEscapeFunction implements Function {
    public Object evaluate(Object arg) {
        return StringEscapeUtils.escapeHtml((String) arg);
    }
}
