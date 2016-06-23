package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it XML-safe.
 */
public class XmlEscapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.escapeXml(Converter.toString(arg));
    }
}
