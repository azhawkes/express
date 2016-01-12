package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it XML-safe.
 */
public class XmlEscapeFunction implements Function {
    public Object evaluate(Object arg) {
        return StringEscapeUtils.escapeXml((String) arg);
    }
}
