package com.sourcerefinery.express.functions;

import com.sourcerefinery.express.Function;
import com.sourcerefinery.express.exceptions.EvaluationException;
import com.sourcerefinery.express.utils.Converter;

import java.io.FileInputStream;
import java.io.IOException;

public class LoadFileFunction implements Function {
    @Override
    public Object evaluate(Object arg) throws EvaluationException {
        String filename = Converter.toString(arg);

        try {
            return new FileInputStream(filename);
        } catch (IOException e) {
            throw new EvaluationException("file not found/readable: " + filename);
        }
    }
}
