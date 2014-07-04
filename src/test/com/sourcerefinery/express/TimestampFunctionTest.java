package com.sourcerefinery.express;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampFunctionTest {
    @Test
    public void testTimestamp() throws Exception {
        String format = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ExpressionContext context = new BasicExpressionContext();
        Expression expression = Expression.parse("timestamp(\"" + format + "\")");
        String output = expression.evaluate(context);

        Assert.assertEquals("Outputs should be the same", formatter.format(new Date()), output);
    }

    @Test
    public void testEmptyTimestamp() throws Exception {
        ExpressionContext context = new BasicExpressionContext();
        Expression expression = Expression.parse("timestamp()");
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);

        Assert.assertEquals("Should be a timestamp", timestamp, expression.evaluate(context));
    }
}
