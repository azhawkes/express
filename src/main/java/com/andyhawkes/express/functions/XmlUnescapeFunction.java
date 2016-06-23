package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it XML-safe.
 */
public class XmlUnescapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.unescapeXml(Converter.toString(arg));
    }
}
