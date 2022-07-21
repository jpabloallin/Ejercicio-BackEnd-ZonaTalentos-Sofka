package com.ejercicio.zonadetalentos.config;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNumber {
    public static String randomAlphanumericNumber() {
        int minLength = 1;
        int maxLength = 4;
        return RandomStringUtils.randomAlphanumeric(minLength,maxLength);
    }

    public static String randomCompetitorNumber() {
        int minLength = 1;
        int maxLength = 4;
        System.out.println(RandomStringUtils.randomNumeric(minLength,maxLength));
        return RandomStringUtils.randomNumeric(minLength,maxLength);
    }
}
