package by.vlasova.service.typo.impl;

import by.vlasova.service.typo.TypoGenerator;

import java.util.Random;

public class Swap implements TypoGenerator {
    private static final int MIN_STRING_SIZE = 2;
    private final Random rnd;

    public Swap(Random rnd) {
        this.rnd = rnd;
    }

    @Override
    public String generateTypo(String s, String locale) {
        if (s.length() < MIN_STRING_SIZE) return s;
        char[] str = s.toCharArray();
        int indexToSwap = rnd.nextInt(s.length() - 1) + 1;
        char tmp = str[indexToSwap];
        str[indexToSwap] = str[indexToSwap - 1];
        str[indexToSwap - 1] = tmp;
        return String.valueOf(str);
    }
}