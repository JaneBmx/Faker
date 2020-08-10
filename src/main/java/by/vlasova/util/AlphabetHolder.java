package by.vlasova.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphabetHolder {
    public static final Map<String, char[]> alphabets;
    public static final Map<String, Boolean> hasMiddleName;
    public static final List<String> locals;

    static {
        alphabets = new HashMap<>();
        hasMiddleName = new HashMap<>();
        locals = new ArrayList<>();
        locals.add("en_us");
        locals.add("ru_ru");
        locals.add("by");
        hasMiddleName.put("en_us", false);
        hasMiddleName.put("ru_ru", true);
        hasMiddleName.put("by", true);
        alphabets.put("en_us", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray());
        alphabets.put("ru_ru", "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789".toCharArray());
        alphabets.put("by", "абвгдеёжзiйклмнопрстуўфхцчшыьэюяАБВГДЕЁЖЗIЙКЛМНОПРСТУЎФХЦЧШЫЬЭЮЯ0123456789".toCharArray());
    }
}