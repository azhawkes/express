package com.sourcerefinery.express;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Unescapes an HTML-escaped string.
 */
public class HtmlUnescapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.unescapeHtml(arg);
    }
}
