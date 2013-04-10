package com.sourcerefinery.express;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An expression. These are used for getting values from data sets, performing simple conversions, etc.
 */
public abstract class Expression {
    private static final Pattern VAR_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?$");
    private static final Pattern ARRAY_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?\\[\\s*?(\\d+)\\s*?]\\s*?$");
    private static final Pattern FUNCTION_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?\\((.*?)\\)\\s*?$");

    public abstract String evaluate(ExpressionContext context);

    public static Expression parse(String str) throws ParseException {
        Matcher matcher;

        if ((matcher = VAR_PATTERN.matcher(str)).matches()) {
            return new VariableExpression(matcher.group(1));
        } else if ((matcher = ARRAY_PATTERN.matcher(str)).matches()) {
            return new VariableExpression(matcher.group(1), Integer.parseInt(matcher.group(2)));
        } else if ((matcher = FUNCTION_PATTERN.matcher(str)).matches()) {
            return new FunctionExpression(matcher.group(1), Expression.parse(matcher.group(2)));
        } else {
            throw new ParseException("unable to parse expression [" + str + "]");
        }
    }
}
