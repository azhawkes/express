package com.andyhawkes.express.utils;

import com.andyhawkes.express.exceptions.EvaluationException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Converter {
    public static String toString(Object object) throws EvaluationException {
        if (object instanceof String) {
            return (String) object;
        } else if (object instanceof InputStream) {
            InputStream input = (InputStream) object;
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            try {
                byte[] buf = new byte[1024];
                int x;

                while ((x = input.read(buf)) >= 0) {
                    output.write(buf, 0, x);
                }

                output.close();
                input.close();
            } catch (IOException e) {
                throw new EvaluationException("unable to convert stream");
            }

            return new String(output.toByteArray());
        } else {
            return object.toString();
        }
    }
}
