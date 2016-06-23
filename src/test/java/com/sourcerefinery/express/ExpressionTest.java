package com.sourcerefinery.express;

import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Test case for expressions and variables.
 */
public class ExpressionTest {

    @Test
    public void testVariableExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon Cornelius");

        String value = Expression.parse("person").evaluateToString(context);

        Assert.assertEquals("Yukon Cornelius", value);
    }

    @Test
    public void testUndefinedVariableExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon Cornelius");

        String value = Expression.parse("dude").evaluateToString(context);

        Assert.assertEquals("", value);
    }

    @Test
    public void testArrayExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("Yukon", Expression.parse("person[0]").evaluateToString(context));
        Assert.assertEquals("Cornelius", Expression.parse("person[1]").evaluateToString(context));
        Assert.assertEquals("yukon@corneliusfamily.com", Expression.parse("person[2]").evaluateToString(context));
        Assert.assertEquals("42", Expression.parse("person[3]").evaluateToString(context));
    }

    @Test
    public void testUndefinedArrayExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("", Expression.parse("dude[0]").evaluateToString(context));
    }

    @Test
    public void testArrayIndexOutOfBounds() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("", Expression.parse("person[18]").evaluateToString(context));
    }

    @Test
    public void testStringExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        Assert.assertEquals("LIZARD", Expression.parse("uppercase(\"lizard\")").evaluateToString(context));
    }

    @Test
    public void testNumberExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        Assert.assertEquals("69", Expression.parse("69").evaluateToString(context));
    }

    @Test
    public void testNumberExpressionWithMath() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setFunction("double", new Function() {
            @Override
            public Object evaluate(Object arg) throws EvaluationException {
                return String.valueOf(Double.parseDouble(Converter.toString(arg)) * 2);
            }
        });

        Assert.assertEquals("276.0", Expression.parse("double(double(69))").evaluateToString(context));
    }

    @Test
    public void testFunctionExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon");

        Assert.assertEquals("YUKON", Expression.parse("uppercase(person)").evaluateToString(context));
    }

    @Test
    public void testNestedFunctionExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("yukon", Expression.parse("lowercase(uppercase(person))").evaluateToString(context));
    }

    @Test
    public void testUrlEncodeExpression() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42", "#@*%#),,-\""});

        Assert.assertEquals("%23%40*%25%23%29%2C%2C-%22", Expression.parse("urlencode(person[4])").evaluateToString(context));
    }

    @Test
    public void testParsingWithWhitespace() throws Exception {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("CORNELIUS", Expression.parse("     uppercase   (           person  [   1   ]       )  ").evaluateToString(context));
    }
}
