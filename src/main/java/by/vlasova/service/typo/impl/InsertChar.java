package by.vlasova.service.typo.impl;

import by.vlasova.service.typo.TypoGenerator;
import by.vlasova.util.AlphabetHolder;

import java.util.Random;

public class InsertChar implements TypoGenerator {
    private final Random rnd;
    private char[] alphabet = null;

    public InsertChar(Random rnd) {
        this.rnd = rnd;
    }

    @Override
    public String generateTypo(String s, String locale) {
        if (alphabet == null) alphabet = AlphabetHolder.alphabets.get(locale.toLowerCase());
        StringBuilder sb = new StringBuilder(s);
        int indexToInsert = s.length() == 0 ? 0 : rnd.nextInt(s.length());
        sb.insert(indexToInsert, alphabet[rnd.nextInt(alphabet.length)]);
        return sb.toString();
    }
}