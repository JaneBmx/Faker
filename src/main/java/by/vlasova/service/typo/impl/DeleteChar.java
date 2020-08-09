package by.vlasova.service.typo.impl;

import by.vlasova.service.typo.TypoGenerator;

import java.util.Random;

public class DeleteChar implements TypoGenerator {
    private static final int MIN_STRING_SIZE = 1;
    private final Random rnd;

    public DeleteChar(Random rnd) {
        this.rnd = rnd;
    }

    @Override
    public String generateTypo(String s, String locale) {
        if (s.length() < MIN_STRING_SIZE) return s;
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(rnd.nextInt(s.length()));
        return sb.toString();
    }
}