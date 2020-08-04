package main;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    private static final Set<String> locales;

    static {
        locales = new HashSet<>();
        locales.add("en_US");
        locales.add("ru_RU");
        locales.add("be_BY");
    }
    public static void main(String[] args) {

    }

    private boolean isValidArgs(String [] arguments){
        return arguments.length>1&&arguments.length<4
                && locales.contains(arguments[0])
                &&isInt(arguments[1]) ;
    }

    private static boolean isInt(String s){
        for (char c: s.toCharArray()){
            if (!Character.isDigit(c))return false;
        }
        return Integer.parseInt(s)>0;
    }
}
