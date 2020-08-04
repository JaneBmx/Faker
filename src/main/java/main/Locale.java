package main;

import java.util.Optional;

public enum Locale {
    RU("ru_RU"),
    EN("en_US"),
    BY("be_BY");

    private String name;

    Locale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public static Optional<Locale> defineByString(String name) {
//        for (Locale locale : values()) {
//            if (locale.getName().equals(name)) return Optional.of(locale);
//        }
//        return Optional.empty();
//    }

}