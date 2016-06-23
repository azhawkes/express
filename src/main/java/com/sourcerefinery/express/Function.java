package com.sourcerefinery.express;

import com.sourcerefinery.express.exceptions.EvaluationException;

/**
 * A simple function that does something with a payload.
 */
public interface Function {
    Object evaluate(Object arg) throws EvaluationException;
}
