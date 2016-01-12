package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it XML-safe.
 */
public class XmlUnescapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.unescapeXml(Converter.toString(arg));
    }
}
