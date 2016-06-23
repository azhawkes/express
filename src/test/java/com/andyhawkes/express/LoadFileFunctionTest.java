package com.andyhawkes.express;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class LoadFileFunctionTest {
    @Test
    public void testLoadFile() throws Exception {
        File file = createRandomFile(777);
        ExpressionContext context = new BasicExpressionContext();
        Expression expression = Expression.parse("loadfile(\"" + file.getAbsolutePath() + "\")");
        InputStream stream = expression.evaluate(context);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int x = stream.read(buf);

        stream.close();
        output.close();

        Assert.assertTrue("Output should be the right size", x == 777);

        if (!file.delete()) {
            throw new IOException("unable to clean up");
        };
    }

    private File createRandomFile(int length) throws IOException {
        File file = File.createTempFile("random-", ".tmp");
        FileOutputStream output = new FileOutputStream(file);
        byte[] random = new byte[length];

        for (int i = 0; i < random.length; i++) {
            random[i] = (byte) (Math.random() * 8);
        }

        output.write(random);
        output.close();

        return file;
    }
}
