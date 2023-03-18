package com.celac.jdbc.app.dao.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTests {

    private String ean128Regex;

    @Before
    public void setUp()  {

        ean128Regex = "(^.{17,60}$)|(^01.{14,60}$)|(^10+[a-zA-Z0-9]+$)";

    }
    @Test
    public void checkRegEx() {
       assert isEAN128("10BATCH123");
    }



    private boolean isEAN128(String ean) {
        Pattern pattern = Pattern.compile(ean128Regex);
        Matcher matcher = pattern.matcher(ean);
        return matcher.matches();
    }
}
