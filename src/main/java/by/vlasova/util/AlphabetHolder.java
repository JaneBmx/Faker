package by.vlasova.util;

import java.util.HashMap;
import java.util.Map;

public class AlphabetHolder {
    public static final Map<String, char[]> alphabets;
    public static final Map<String, Boolean> hasMiddleName;

    static {
        alphabets = new HashMap<>();
        hasMiddleName = new HashMap<>();
        hasMiddleName.put("en_us", false);
        hasMiddleName.put("ru_ru", true);
        hasMiddleName.put("by", true);
        alphabets.put("en_us", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray());
        alphabets.put("ru_ru", "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789".toCharArray());
        alphabets.put("by", "абвгдеёжзiйклмнопрстуўфхцчшыьэюяАБВГДЕЁЖЗІЙКЛМНОПРСТУЎФХЦЧШЫЬЭЮЯ0123456789".toCharArray());
    }
}