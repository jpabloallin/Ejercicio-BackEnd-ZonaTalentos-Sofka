package com.ejercicio.zonadetalentos.config;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphanumeric {
    public static String randomAlphanumericNumber() {
        int count = 3;
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
