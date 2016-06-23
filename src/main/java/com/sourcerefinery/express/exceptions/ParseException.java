package com.sourcerefinery.express.exceptions;

/**
 * Exception that means an expression failed to parse.
 */
public class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
}
