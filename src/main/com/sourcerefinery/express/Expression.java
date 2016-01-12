package com.sourcerefinery.express;

import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.exceptions.ParseException;
import com.sourcerefinery.express.utils.Converter;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An expression. These are used for getting values from data sets, performing simple conversions, etc.
 */
public abstract class Expression {
    private static final Pattern STRING_PATTERN = Pattern.compile("^\\s*?\"(.*)\"\\s*?$");
    private static final Pattern VAR_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?$");
    private static final Pattern ARRAY_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?\\[\\s*?(\\d+)\\s*?]\\s*?$");
    private static final Pattern FUNCTION_PATTERN = Pattern.compile("^\\s*?(\\w+)\\s*?\\((.*?)\\)\\s*?$");
    private static final Pattern EMPTY_PATTERN = Pattern.compile("^\\s*$");

    public abstract InputStream evaluate(ExpressionContext context) throws EvaluationException;

    public String evaluateToString(ExpressionContext context) throws EvaluationException {
        return Converter.toString(evaluate(context));
    }

    public static Expression parse(String str) throws ParseException {
        Matcher matcher;

        if ((matcher = STRING_PATTERN.matcher(str)).matches()) {
            return new StringExpression(matcher.group(1));
        } else if ((matcher = VAR_PATTERN.matcher(str)).matches()) {
            return new VariableExpression(matcher.group(1));
        } else if ((matcher = ARRAY_PATTERN.matcher(str)).matches()) {
            return new VariableExpression(matcher.group(1), Integer.parseInt(matcher.group(2)));
        } else if ((matcher = FUNCTION_PATTERN.matcher(str)).matches()) {
            return new FunctionExpression(matcher.group(1), Expression.parse(matcher.group(2)));
        } else if ((matcher = EMPTY_PATTERN.matcher(str)).matches()) {
            return new StringExpression("");
        } else {
            throw new ParseException("unable to parse expression [" + str + "]");
        }
    }
}
