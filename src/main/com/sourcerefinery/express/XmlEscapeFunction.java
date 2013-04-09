package com.sourcerefinery.express;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it XML-safe.
 */
public class XmlEscapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.escapeXml(arg);
    }
}
