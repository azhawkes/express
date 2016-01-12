package com.sourcerefinery.express.exceptions;

/**
 * Exception that means an expression failed to evaluate.
 */
public class EvaluationException extends Exception {
    public EvaluationException(String message) {
        super(message);
    }
}
