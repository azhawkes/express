package com.sourcerefinery.express;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Test case for expressions and variables.
 */
public class ExpressionTest {

    @Test
    public void testVariableExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon Cornelius");

        String value = Expression.parse("person").evaluate(context);

        Assert.assertEquals("Yukon Cornelius", value);
    }

    @Test
    public void testUndefinedVariableExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon Cornelius");

        String value = Expression.parse("dude").evaluate(context);

        Assert.assertEquals("", value);
    }

    @Test
    public void testArrayExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("Yukon", Expression.parse("person[0]").evaluate(context));
        Assert.assertEquals("Cornelius", Expression.parse("person[1]").evaluate(context));
        Assert.assertEquals("yukon@corneliusfamily.com", Expression.parse("person[2]").evaluate(context));
        Assert.assertEquals("42", Expression.parse("person[3]").evaluate(context));
    }

    @Test
    public void testUndefinedArrayExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("", Expression.parse("dude[0]").evaluate(context));
    }

    @Test
    public void testArrayIndexOutOfBounds() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("", Expression.parse("person[18]").evaluate(context));
    }

    @Test
    public void testStringExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        Assert.assertEquals("LIZARD", Expression.parse("uppercase(\"lizard\")").evaluate(context));
    }

    @Test
    public void testFunctionExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setVariable("person", "Yukon");

        Assert.assertEquals("YUKON", Expression.parse("uppercase(person)").evaluate(context));
    }

    @Test
    public void testNestedFunctionExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("yukon", Expression.parse("lowercase(uppercase(person))").evaluate(context));
    }

    @Test
    public void testUrlEncodeExpression() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42", "#@*%#),,-\""});

        Assert.assertEquals("%23%40*%25%23%29%2C%2C-%22", Expression.parse("urlencode(person[4])").evaluate(context));
    }

    @Test
    public void testParsingWithWhitespace() throws ParseException {
        BasicExpressionContext context = new BasicExpressionContext();

        context.setArray("person", new String[]{"Yukon", "Cornelius", "yukon@corneliusfamily.com", "42"});

        Assert.assertEquals("CORNELIUS", Expression.parse("     uppercase   (           person  [   1   ]       )  ").evaluate(context));
    }
}
