package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Function that outputs a date formatted timestamp of the current date and time.
 * The pattern syntax is the same as SimpleDateFormat in Java.
 */
public class TimestampFunction implements Function {
    public Object evaluate(Object arg) throws EvaluationException {
        String format = Converter.toString(arg);

        try {
            if (StringUtils.isEmpty(format)) {
                return String.valueOf(System.currentTimeMillis() / 1000L);
            } else {
                SimpleDateFormat formatter = new SimpleDateFormat(format);

                return formatter.format(new Date());
            }
        } catch (Exception e) {
            throw new EvaluationException("unable to handle date format [" + format + "]");
        }
    }
}
