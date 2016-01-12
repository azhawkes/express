package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Unescapes an HTML-escaped string.
 */
public class HtmlUnescapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.unescapeHtml(Converter.toString(arg));
    }
}
