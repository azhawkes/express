package com.sourcerefinery.express;

import org.apache.log4j.Logger;

import java.net.URLDecoder;

/**
 * Basic URL decoding on a string.
 */
public class UrlDecodeFunction implements com.sourcerefinery.express.Function {
    private static final Logger log = Logger.getLogger(UrlDecodeFunction.class);

    public String evaluate(String arg) {
        try {
            return URLDecoder.decode(arg, "UTF-8");
        } catch (Exception e) {
            log.warn("failed to decode URL encoded string [" + arg + "]", e);
        }

        return "";
    }
}
