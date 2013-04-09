package com.sourcerefinery.express;

import org.apache.log4j.Logger;

import java.net.URLEncoder;

/**
 * Basic URL encoding on a string.
 */
public class UrlEncodeFunction implements Function {
    private static final Logger log = Logger.getLogger(UrlEncodeFunction.class);

    public String evaluate(String arg) {
        try {
            return URLEncoder.encode(arg, "UTF-8");
        } catch (Exception e) {
            log.warn("failed to urlencode string [" + arg + "]", e);
        }

        return "";
    }
}
