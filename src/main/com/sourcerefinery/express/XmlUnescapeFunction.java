package com.sourcerefinery.express;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it XML-safe.
 */
public class XmlUnescapeFunction implements Function {
    public String evaluate(String arg) {
        return StringEscapeUtils.unescapeXml(arg);
    }
}
