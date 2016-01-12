package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Unescapes an HTML-escaped string.
 */
public class HtmlUnescapeFunction implements Function {
    public Object evaluate(Object arg) {
        return StringEscapeUtils.unescapeHtml((String) arg);
    }
}
