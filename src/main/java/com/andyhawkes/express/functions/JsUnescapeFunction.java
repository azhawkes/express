package com.andyhawkes.express.functions;

import com.andyhawkes.express.Function;
import com.andyhawkes.express.exceptions.EvaluationException;
import com.andyhawkes.express.utils.Converter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Un-escapes a string that was previously escaped to make it safe for JavaScript.
 */
public class JsUnescapeFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        return StringEscapeUtils.unescapeJavaScript(Converter.toString(arg));
    }
}
