package by.vlasova.util.validator;

import java.util.HashSet;
import java.util.Set;

/**
 * Args:
 * 1. Locale name:{ru_RU, en_EN, by_BY}
 * 2. Count of records:{1, 2, 3, ...}
 * 3. Percent of mistakes:{0<....}
 */
public class ArgumentsValidator {
    private Set<String> localeValues;

    {
        localeValues = new HashSet<>();
        localeValues.add("ru_RU");
        localeValues.add("en_EN");
        localeValues.add("by_BY");
        localeValues.add("by");
        localeValues.add("ru");
        localeValues.add("en");
    }

    public boolean isValid(String[] arguments) {
        return (arguments.length == 2 || arguments.length == 3)
                && localeValues.contains(arguments[1])
                && isNaturalNumber(arguments[1]);
    }

    private boolean isNaturalNumber(String number) {
        try {
            int natural = Integer.parseInt(number);
            return natural > 0;
        } catch (Exception e) {
            return false;
        }
    }
}