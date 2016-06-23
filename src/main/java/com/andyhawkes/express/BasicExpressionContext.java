package com.andyhawkes.express;

import com.andyhawkes.express.functions.*;

import java.util.Hashtable;
import java.util.Map;

/**
 * Basic expression context that uses simple maps to keep track of its functions and variables.
 */
public class BasicExpressionContext implements ExpressionContext {
    private Map<String, String[]> variables = new Hashtable<>();
    private Map<String, Function> functions = new Hashtable<>();

    public BasicExpressionContext() {
        functions.put("uppercase", new UppercaseFunction());
        functions.put("lowercase", new LowercaseFunction());
        functions.put("urlencode", new UrlEncodeFunction());
        functions.put("urldecode", new UrlDecodeFunction());
        functions.put("xmlescape", new XmlEscapeFunction());
        functions.put("xmlunescape", new XmlUnescapeFunction());
        functions.put("htmlescape", new HtmlEscapeFunction());
        functions.put("htmlunescape", new HtmlUnescapeFunction());
        functions.put("jsescape", new JsEscapeFunction());
        functions.put("jsunescape", new JsUnescapeFunction());
        functions.put("timestamp", new TimestampFunction());
        functions.put("loadfile", new LoadFileFunction());
    }

    public String getVariable(String name) {
        String[] values = variables.get(name);

        if (values == null) {
            return "";
        } else {
            return values[0];
        }
    }

    public String getVariable(String name, int index) {
        String[] values = variables.get(name);

        if (values != null && values.length > index) {
            return values[index];
        } else {
            return "";
        }
    }

    public void setVariable(String name, String value) {
        variables.put(name, new String[]{value});
    }

    public void setArray(String name, String[] value) {
        variables.put(name, value);
    }

    public Function getFunction(String name) {
        return functions.get(name);
    }

    public void setFunction(String name, Function function) {
        functions.put(name, function);
    }
}
