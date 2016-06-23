package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escapes a string to make it XML-safe.
 */
public class XmlEscapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.escapeXml(Converter.toString(arg));
    }
}
